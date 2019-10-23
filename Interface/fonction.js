function afficheDate(){
	jours = new Array('Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi'); 
	mois = new Array('Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Août',
					 'Septembre', 'Octobre', 'Décembre');
     var aujourdhui = new Date(); 
     var result = jours[aujourdhui.getDay()] + ", le " + aujourdhui.getDate() + " " + 
	 mois[aujourdhui.getMonth()] + " " + aujourdhui.getFullYear(); 
	document.writeln(result);
}

function SubmitList()
{
    //Variable declaration
    var idItem = document.getElementById("id").value;
    var nameItem = document.getElementById("name").value;
    var myNode = document.getElementById("table1");

    //Deletes all existing entries
    while (myNode.firstChild) {
        myNode.removeChild(myNode.firstChild);
    }
    if(idItem != "")
    {
        window.JavaApp.ListItemById(idItem);
    }
    else if(nameItem != "")
    {
        window.JavaApp.ListItemByName(nameItem);
    }
    else
    {
        window.JavaApp.ListAllItem();
    }
}
function SubmitDelete()
{
    window.JavaApp.ListAllDeleteItem();
}
function DeleteItem()
 {
     Alert(arguments[0]);
 }

 function ResetSupprimer()
 {
     //Variable declaration
    document.getElementById("id").value = "";
 }

 function ResetAjouter()
 {
    document.getElementById("upc").value = "";
    document.getElementById("emplacement").value = "";
    document.getElementById("description").value = "";
 }

function ResetList()
{
    myNode = document.getElementById("table1");
    while (myNode.firstChild) {
        myNode.removeChild(myNode.firstChild);
    }
}
function ShowItem()
{
    var row = document.createElement("tr");
    var column
    for(var i = 0; i < arguments.length; i++)
    {
         column = document.createElement("td");
         column.innerHTML = arguments[i];
         row.appendChild(column);
    }
    document.getElementById("table1").appendChild(row);
}
function ShowDeleteItem()
{
    var row = document.createElement("tr");
    var column
    for(var i = 0; i < arguments.length; i++)
    {
         column = document.createElement("td");
         column.innerHTML = arguments[i];
         row.appendChild(column);
    }
    column2 = document.createElement("td");
    column3 = document.createElement("td");
    column2.innerHTML = "<input type='text' class='form-control' placeholder='Quantité à enlever'>";
    column3.innerHTML = "<button class='btn btn-default' onclick='DeleteItem(" + arguments[0] + ");' >Retirer</button>";
    row.appendChild(column);
    row.appendChild(column2);
    row.appendChild(column3);

    document.getElementById("table1").appendChild(row);
}
function Alert(msg)
{
    window.alert(msg);
}

function CreateItem()
{
   var upc =  document.getElementById("upc").value;
   var emplacement = document.getElementById("emplacement").value;
   var description =  document.getElementById("description").value;

    if(window.JavaApp.CreateItem(upc,emplacement,description))
    {
        ResetAjouter();
    }
}