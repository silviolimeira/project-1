
function verificarTelefone() {

    var regex = new RegExp('^\\([0-9]{2}\\)((3[0-9]{3}-[0-9]{4})|(9[0-9]{3}-[0-9]{5}))$');

    if (regex.test(document.form.telefone.value)) {
        if (document.form.nome.value != "") {
            return true;
        } else {
            document.getElementById("mensagem").innerHTML =
                "O preenchimento do campo nome ? obrigat?rio.";
            document.form.nome.focus();
            return false;
        }
    } else {

        document.getElementById("mensagem").innerHTML =
            "?? x1x Telefone inv?lido x.";
            document.form.telefone.focus();
            return false;
    }
}