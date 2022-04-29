
function encodeHtml(mensagem) {

    var acentos = ["á","à","â","ã","ä","Á","À","Â","Ã","Ä","é","è","ê","ê","É","È","Ê","Ë","í","ì","î","ï","Í","Ì","Î","Ï","ó","ò","ô","õ","ö","Ó","Ò","Ô","Õ","Ö","ú","ù","û","ü","Ú","Ù","Û","ç","Ç","ñ","Ñ","&","‘"];
    var resultado = ["\u00e1","\u00e0","\u00e2","\u00e3","\u00e4","\u00c1","\u00c0","\u00c2","\u00c3","\u00c4","\u00e9","\u00e8","\u00ea","\u00ea","\u00c9","\u00c8","\u00ca","\u00cb","\u00ed","\u00ec","\u00ee","\u00ef","\u00cd","\u00cc","\u00ce","\u00cf","\u00f3","\u00f2","\u00f4","\u00f5","\u00f6","\u00d3","\u00d2","\u00d4","\u00d5","\u00d6","\u00fa","\u00f9","\u00fb","\u00fc","\u00da","\u00d9","\u00db","\u00e7","\u00c7","\u00f1","\u00d1","\u0026","\u0027"];

    var men = "";

    for (var i = 0; i < mensagem.length; i++) {
        var idx = acentos.indexOf(mensagem[i]);
        if (idx != -1) {
            men += resultado[acentos.indexOf(mensagem[i])];
        } else {
            men += mensagem[i];
        }
    }

    return men;
}

