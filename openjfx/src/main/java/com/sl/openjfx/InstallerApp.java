//package com.sl.openjfx;
//
//import com.sl.openjfx.business.CalculaHorarioDeTrabalho;
//import com.sl.openjfx.model.Periodo;
//import com.sl.openjfx.ui.WorkSchedule;
//import com.sl.openjfx.ui.WorkScheduleReport;
//import javafx.application.Application;
//import javafx.application.HostServices;
//import javafx.application.Platform;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.concurrent.Task;
//import javafx.event.EventHandler;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.ScrollPane;
//import javafx.scene.control.TableView;
//import javafx.scene.image.Image;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//import javafx.stage.WindowEvent;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.data.JRCsvDataSource;
//import org.springframework.boot.SpringApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.support.GenericApplicationContext;
//import org.springframework.context.support.StaticApplicationContext;
//
//import java.io.*;
//import java.nio.charset.StandardCharsets;
//import java.util.*;
//
//public class InstallerApp extends Application {
//
//	WorkSchedule horarioTrabalho;
//
//	WorkSchedule marcacoes;
//
//	WorkScheduleReport atraso;
//
//	WorkScheduleReport horaExtra;
//
//	CalculaHorarioDeTrabalho calculaHorarioDeTrabalho = new CalculaHorarioDeTrabalho();
//
//	private boolean cancelTreads = false;
//
//	private TableView<Periodo> table = new TableView<Periodo>();
//
//	private final ObservableList<Periodo> data = FXCollections.observableArrayList();
//
//	final HBox hb = new HBox();
//
//	/////////////////////////////////////////////////////////////////////////
//
//	private ApplicationContext context;
//
//	private Scene scene;
//
//	@Override
//	public void init() {
//
//		final GenericApplicationContext parentContext = new StaticApplicationContext();
//		parentContext.getBeanFactory().registerSingleton(this.getClass().getSimpleName(), this);
//		parentContext.refresh();
//
//		SpringApplication application = new SpringApplication(MySpringContext.class) {
//
//			@Override
//			protected ConfigurableApplicationContext createApplicationContext() {
//				// create the Spring context and inject the static parent context
//				final ConfigurableApplicationContext applicationContext = super.createApplicationContext();
//				applicationContext.setParent(parentContext);
//				return applicationContext;
//			}
//
//		};
//
//		this.context = application.run();
//
//	}
//
//	public Task taskSubtracaoEntreHorarios() {
//		return new Task() {
//			@Override
//			protected Object call() throws Exception {
//
//				String workDir = System.getProperty("user.dir");
//				System.out.println("User dir: " + workDir);
//				int cnt = 0;
//				while (!cancelTreads) {
//					System.out.print(".");
//					Thread.sleep(1000);
//					// System.out.println(horarioTrabalho.getTable().getItems().size());
//
//					if (horarioTrabalho.isUpdated() || marcacoes.isUpdated()) {
//						Platform.runLater(() -> {
//							try {
//								System.out.println("#");
//								horarioTrabalho.setUpdated(false);
//								marcacoes.setUpdated(false);
//
//								int max = horarioTrabalho.getTableAsList().size();
//								System.out.println("Horario Trabalho: ### " + max);
//
//								horaExtra.getTable().getItems().clear();
//								atraso.getTable().getItems().clear();
//
//								calculaHorarioDeTrabalho.calculaHoraExtraAtraso(horaExtra, atraso, horarioTrabalho,
//										marcacoes);
//
//							}
//							catch (Exception e) {
//								e.printStackTrace();
//							}
//						});
//					}
//					if (horarioTrabalho.isEmitirRelatorio()) {
//						horarioTrabalho.setEmitirRelatorio(false);
//						exportReport();
//						System.out.println("Emitindo relatorio ...");
//						// ProcessBuilder p = new ProcessBuilder();
//						// String userDir = System.getProperty("user.dir");
//						// System.out.println("start " + userDir + "\\report.pdf");
//						// p.command("start " + userDir + "\\report.pdf");
//						// p.start();
//					}
//					cnt++;
//					if (cnt > 10) {
//						cnt = 0;
//						horarioTrabalho.setUpdated(true);
//						marcacoes.setUpdated(true);
//						System.out.print("#");
//					}
//
//				}
//
//				if (cancelTreads)
//					return false;
//
//				return true;
//			}
//		};
//	}
//
//	@Override
//	public void start(final Stage stage) {
//
//		// Tools tools = new Tools();
//		// tools.hello();
//
//		Image image = new Image(InstallerApp.class.getResourceAsStream("/images/logo.png"));
//		stage.getIcons().add(image);
//		stage.setTitle("Desafio");
//		// stage.setWidth(800);
//		// stage.setHeight(600);
//
//		Group root = new Group();
//
//		Scene scene = new Scene(root, 600, 600, Color.LIGHTGREY);
//
//		BorderPane mainPane = new BorderPane();
//
//		ScrollPane scrollPanePane = new ScrollPane();
//		scrollPanePane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
//		scrollPanePane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
//		scrollPanePane.setPrefViewportWidth(580);
//		scrollPanePane.setFitToWidth(true);
//		scrollPanePane.setFitToHeight(true);
//
//		scrollPanePane.setContent(mainPane);
//
//		root.getChildren().add(scrollPanePane);
//
//		horarioTrabalho = new WorkSchedule();
//		horarioTrabalho.setBotaoRelatorio(true);
//		marcacoes = new WorkSchedule();
//		atraso = new WorkScheduleReport();
//		horaExtra = new WorkScheduleReport();
//
//		mainPane.setTop(horarioTrabalho.getComponent("Horário de Trabalho", 3));
//		mainPane.setCenter(marcacoes.getComponent("Marcações Feitas"));
//
//		final HBox hb = new HBox();
//		hb.getChildren().addAll(atraso.getComponent("Atraso"), horaExtra.getComponent("Hora Extra"));
//		hb.setSpacing(3);
//		mainPane.setBottom(hb);
//
//		new Thread(taskSubtracaoEntreHorarios()).start();
//
//		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//			@Override
//			public void handle(WindowEvent t) {
//				cancelTreads = true;
//				Platform.exit();
//				System.exit(0);
//			}
//		});
//
//		stage.setScene(scene);
//		stage.show();
//
//	}
//
//	@Override
//	public void stop() {
//
//		SpringApplication.exit(this.context);
//
//	}
//
//	public static void main(final String[] args) {
//		launch(args);
//	}
//
//	private void processLines(List<Periodo> listPeriodo, String titulo, List<String> lines, Integer seq) {
//
//		for (int i = 0; i < listPeriodo.size(); i++) {
//			Periodo p = listPeriodo.get(i);
//			String[] tmp = p.toString().split(" ");
//			if (tmp.length == 2) {
//				String line = "\"" + titulo + "\"," + seq + ",\"" + tmp[0] + "\",\"" + tmp[1] + "\"";
//				lines.add(line);
//			}
//			System.out.println(p.toString());
//		}
//		seq++;
//
//	}
//
//	private void processReport() {
//		String userDir = System.getProperty("user.dir");
//		File file = new File(userDir + "\\RelatorioApontamentos.txt");
//		List<String> lines = new ArrayList<>();
//		Integer seq = 1;
//
//		processLines(horarioTrabalho.getTable().getItems(), "Horario de Trabalho", lines, seq);
//		processLines(marcacoes.getTable().getItems(), "Marcações Feitas", lines, seq);
//		processLines(atraso.getTable().getItems(), "Atrasos", lines, seq);
//		processLines(horaExtra.getTable().getItems(), "Horas Extras", lines, seq);
//
//		try (FileOutputStream fos = new FileOutputStream(file);
//				OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
//				BufferedWriter writer = new BufferedWriter(osw)) {
//
//			for (String line : lines) {
//				writer.append(line);
//				writer.newLine();
//			}
//
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void exportReport() throws JRException {
//
//		processReport();
//
//		String userDir = System.getProperty("user.dir");
//		System.out.println(userDir);
//		// userDir = "d:\\temp";
//
//		Map<String, Object> parameters = new HashMap<String, Object>();
//		parameters.put("ReportTitle", "Relatório de Apontamentos");
//		parameters.put("DataFile", "Horário de Trabalho, Marcações, Horas Extras e Atrasos");
//		Set<String> states = null; // new HashSet<String>();
//		// states.add("Active");
//		// states.add("Trial");
//		parameters.put("IncludedStates", states);
//
//		String[] columnNames = new String[] { "periodo", "id", "entrada", "saida" };
//		JRCsvDataSource dataSource = null;
//		try {
//			dataSource = new JRCsvDataSource(userDir + "\\RelatorioApontamentos.txt", "utf8");
//		}
//		catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//
//		dataSource.setRecordDelimiter("\r\n");
//		dataSource.setColumnNames(columnNames);
//		JasperReport jasperReport = JasperCompileManager.compileReport(userDir + "\\RelatorioApontamentos.jrxml");
//		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//		jasperPrint.setLocaleCode("utf8");
//
//		JasperExportManager.exportReportToPdfFile(jasperPrint, userDir + "\\report.pdf");
//
//		File file = new File(userDir + "\\report.pdf");
//		HostServices hostServices = getHostServices();
//		hostServices.showDocument(file.getAbsolutePath());
//	}
//
//}
