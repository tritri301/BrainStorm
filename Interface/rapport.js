function CreateCSVFile()
{
    window.JavaApp.CreateCSVFile();
    window.alert("Fichier CSV générer avec succès");
}

function CreateExcelFile()
{
    window.JavaApp.CreateExcelFile();
    window.alert("Aucun fichier généré, veuillez contacter la personne en charge du logiciel");
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
         column = document.createElement("td","a");
         column.innerHTML = arguments[i];
         column.href = "arguments[0]";
         column.setAttribute("onclick","window.open(" + "'" +arguments[0]+ "'" + ");");
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

    if (sel.value == "ascendant") window.JavaApp.ShowRapportInterface("true");

    else if (sel.value == "descendant")window.JavaApp.ShowRapportInterface("false");
}