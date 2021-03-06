package com.sl.openjfx.ui;

import com.sl.openjfx.business.CalculaHorarioDeTrabalho;
import com.sl.openjfx.model.Periodo;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Callback;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRCsvDataSource;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WorkSchedule {

	private VBox vbox = new VBox();

	private TableView<Periodo> table = new TableView<Periodo>();

	CalculaHorarioDeTrabalho calculaHorarioDeTrabalho = new CalculaHorarioDeTrabalho();

	private ObservableList<Periodo> data = FXCollections.observableArrayList();

	private int maxLines = 3;

	private boolean updated = false;

	private boolean botaoRelatorio = false;

	private boolean emitirRelatorio = false;

	public WorkSchedule() {

	}

	public boolean isBotaoRelatorio() {
		return botaoRelatorio;
	}

	public void setBotaoRelatorio(boolean botaoRelatorio) {
		this.botaoRelatorio = botaoRelatorio;
	}

	public boolean isEmitirRelatorio() {
		return emitirRelatorio;
	}

	public void setEmitirRelatorio(boolean emitirRelatorio) {
		this.emitirRelatorio = emitirRelatorio;
	}

	public void setUpdated(boolean updated) {
		this.updated = updated;
	}

	public boolean isUpdated() {
		return this.updated;
	}

	public ObservableList<Periodo> getData() {
		return this.data;
	}

	public TableView<Periodo> getTable() {
		return this.table;
	}

	public SortedList<Periodo> getTableAsList() {

		ObservableList<Periodo> stringObservableList = FXCollections.observableArrayList(this.table.getItems());

		SortedList<Periodo> sortedList = new SortedList<Periodo>(stringObservableList, new Comparator<Periodo>() {
			@Override
			public int compare(Periodo o1, Periodo o2) {
				return o1.toString().compareToIgnoreCase(o2.toString());
			}

		});

		return sortedList;

	}

	private void addButtonToTable() {
		TableColumn<Periodo, Void> colBtn = new TableColumn("");

		Callback<TableColumn<Periodo, Void>, TableCell<Periodo, Void>> cellFactory = new Callback<TableColumn<Periodo, Void>, TableCell<Periodo, Void>>() {

			public TableCell<Periodo, Void> call(final TableColumn<Periodo, Void> param) {
				final TableCell<Periodo, Void> cell = new TableCell<Periodo, Void>() {

					private final Button btn = new Button("Deletar");

					{
						btn.setOnAction((ActionEvent event) -> {
							Periodo data = getTableView().getItems().get(getIndex());
							System.out.println("selectedData: " + data.getEntrada());
							data.getSaida();
							getTableView().getItems().remove(getIndex());
							setUpdated(true);
						});
					}

					@Override
					public void updateItem(Void item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
						}
						else {
							setGraphic(btn);
						}
					}
				};
				return cell;
			}
		};

		colBtn.setCellFactory(cellFactory);

		table.getColumns().add(colBtn);

	}

	public VBox getComponent(String title) {
		return this.getComponent(title, Integer.MAX_VALUE);
	}

	public VBox getComponent(String title, int maxLines) {

		this.maxLines = maxLines;

		final Label label = new Label(title);
		label.setFont(new Font("Arial", 20));

		table.setEditable(false);
		Callback<TableColumn, TableCell> cellFactory = new Callback<TableColumn, TableCell>() {
			public TableCell call(TableColumn p) {
				return new EditingCell();
			}
		};

		TableColumn entradaCol = new TableColumn("Entrada");
		entradaCol.setMinWidth(100);
		entradaCol.setCellValueFactory(new PropertyValueFactory<Periodo, String>("entrada"));
		entradaCol.setCellFactory(cellFactory);
		entradaCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Periodo, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Periodo, String> t) {
				((Periodo) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEntrada(t.getNewValue());
			}
		});

		TableColumn saidaCol = new TableColumn("Sa??da");
		saidaCol.setMinWidth(100);
		saidaCol.setCellValueFactory(new PropertyValueFactory<Periodo, String>("saida"));
		saidaCol.setCellFactory(cellFactory);
		saidaCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Periodo, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Periodo, String> t) {
				((Periodo) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSaida(t.getNewValue());
			}
		});

		table.setItems(data);
		table.getColumns().addAll(entradaCol, saidaCol);
		addButtonToTable();

		final TextField addEntrada = new TextField();
		// force the field to be numeric only
		addEntrada.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (addEntrada.getText().length() > 5) {
					String s = addEntrada.getText().substring(0, 5);
					addEntrada.setText(s);
				}
				if (!newValue.matches("\\d*")) {
					addEntrada.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		addEntrada.setPromptText("Entrada");
		addEntrada.setMaxWidth(entradaCol.getPrefWidth());

		final TextField addSaida = new TextField();
		addSaida.setMaxWidth(saidaCol.getPrefWidth());
		addSaida.setPromptText("Sa??da");

		final Button addButton = new Button("Adicionar");
		Hour entrada = new Hour();
		Hour saida = new Hour();
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (table.getItems().size() >= maxLines)
					return;
				if (entrada.isValid() && saida.isValid()) {
					Periodo periodo = new Periodo(entrada.toString(), saida.toString());
					Platform.runLater(() -> {
						try {
							if (!calculaHorarioDeTrabalho.testaIntersecaoPeriodos(periodo, getTableAsList())) {
								// System.out.println("testa periodo: " +
								// calculaHorarioDeTrabalho.testaIntersecaoPeriodos(periodo,
								// getTableAsList()));
								// entrada.invalidate();
								// saida.invalidate();
							}
							else {
								data.add(periodo);
								entrada.clear();
								saida.clear();
								setUpdated(true);
							}
						}
						catch (Exception ex) {
							ex.printStackTrace();
						}
					});
				}
			}
		});

		final Button cleanButton = new Button("Limpar Tabela");
		cleanButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (table.getItems().size() >= maxLines)
					return;
				entrada.clear();
				saida.clear();
				data.clear();
				setUpdated(true);

			}
		});

		Button relatorio = null;
		if (isBotaoRelatorio()) {
			relatorio = new Button("Relat??rio");
			relatorio.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					Platform.runLater(() -> {
						try {
							// exportReport();
							setEmitirRelatorio(true);
						}
						catch (Exception ex) {
							ex.printStackTrace();
						}
					});
				}
			});
		}

		final HBox hb = new HBox();
		hb.setSpacing(10);
		hb.getChildren().addAll(entrada.getComponent("Entrada:"), saida.getComponent("Sa??da:"), addButton, cleanButton);

		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		// vbox.getChildren().addAll(label, table, hb);
		if (relatorio != null) {
			vbox.getChildren().addAll(label, table, hb, relatorio);
		}
		else {
			vbox.getChildren().addAll(label, table, hb);
		}

		vbox.setMaxHeight(200.0);

		return vbox;

	}

	private String readFromInputStream(InputStream inputStream) throws IOException {
		StringBuilder resultStringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line).append("\n");
			}
		}
		return resultStringBuilder.toString();
	}

	private void exportReport() throws JRException {

		String userDir = System.getProperty("user.dir");
		System.out.println(userDir);
		// userDir = "d:\\temp";

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("ReportTitle", "Relat??rio de Apontamentos");
		parameters.put("DataFile", "Hor??rio de Trabalho, Marca????es, Horas Extras e Atrasos");
		Set<String> states = null; // new HashSet<String>();
		// states.add("Active");
		// states.add("Trial");
		parameters.put("IncludedStates", states);

		String[] columnNames = new String[] { "periodo", "id", "entrada", "saida" };
		JRCsvDataSource dataSource = null;
		try {
			dataSource = new JRCsvDataSource(userDir + "\\RelatorioApontamentos.txt", "utf8");
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		dataSource.setRecordDelimiter("\r\n");
		dataSource.setColumnNames(columnNames);
		JasperReport jasperReport = JasperCompileManager.compileReport(userDir + "\\RelatorioApontamentos.jrxml");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		jasperPrint.setLocaleCode("utf8");

		JasperExportManager.exportReportToPdfFile(jasperPrint, userDir + "\\report.pdf");
	}

}
