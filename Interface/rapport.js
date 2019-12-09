function CreateCSVFile()
{
    window.JavaApp.CreateCSVFile();
    window.alert("Fichier CSV générer avec succès");
}

function CreateExcelFile()
{
    window.JavaApp.CreateExcelFile();
    window.alert("Fichier Excel générer avec succès");
}

function showListFolder()
{
    window.JavaApp.ShowRapportInterface();
}

function createTable()
{
    var row = document.createElement("tr");
    var column;
    for(var i = 0; i < arguments.length; i++)
    {
         column = document.createElement("td");
         column.innerHTML = "<a href='"+arguments[i]+"'>" +arguments[i] + "</a>";
         row.appendChild(column);
    }
    document.getElementById("table2").appendChild(row);
}

function getval(sel)
{
     myNode = document.getElementById("table2");

     //Deletes all existing entries
     while (myNode.firstChild) {
         myNode.removeChild(myNode.firstChild);
     }

    if (sel.value == "ascendant") window.JavaApp.ShowRapportInterface("ascendant");

    else if (sel.value == "descendant")window.JavaApp.ShowRapportInterface("descendant");

}