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
    var idItem = document.getElementById("upc").value;
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

function creerRapport(){
var myNode = document.getElementById("table2");

    while (myNode.firstChild) {
        myNode.removeChild(myNode.firstChild);
    }
        window.JavaApp.ListAllItemRapport();
}

function SubmitDelete()
{
    upc = document.getElementById("upc").value;
    myNode = document.getElementById("table1");

    //Deletes all existing entries
    while (myNode.firstChild) {
        myNode.removeChild(myNode.firstChild);
    }
    if(upc != "")
    {
        window.JavaApp.ListDeleteItemByUPC(upc);
    }
    else
    {
        window.JavaApp.ListAllDeleteItem();
    }
}
function DeleteItem()
 {
     if(confirm("Voulez-vous vraiment retirer cet item?"))
     {
        quantite = document.getElementById(arguments[0]).value;
        window.JavaApp.DeleteItem(arguments[0], quantite);
     }
     SubmitDelete();
 }

 function ResetSupprimer()
 {
    document.getElementById("upc").value = "";
     myNode = document.getElementById("table1");

     //Deletes all existing entries
     while (myNode.firstChild) {
         myNode.removeChild(myNode.firstChild);
     }
 }

 function ResetAjouter()
 {
    document.getElementById("upc").value = "";
    document.getElementById("qt").value = "";
    document.getElementById("description").value = "";
    document.getElementById("TxtBoxRanger").value = "";
    document.getElementById("TxtBoxEtagere").value = "";
    document.getElementById("TxtBoxTablette").value = "";
 }

function ResetList()
{
    document.getElementById("upc").value = "";
    document.getElementById("name").value = "";
    myNode = document.getElementById("table1");
    while (myNode.firstChild) {
        myNode.removeChild(myNode.firstChild);
    }
}
function ShowItem()
{
    var row = document.createElement("tr");
    var column;
    for(var i = 0; i < arguments.length; i++)
    {
         column = document.createElement("td");
         column.innerHTML = arguments[i];
         column.setAttribute("onclick","Alert(" + "'" + arguments[2] + "'" + ");");
         row.appendChild(column);
    }
    document.getElementById("table1").appendChild(row);
}

function ShowItemRapport()
{
    var row = document.createElement("tr");
    var column;
    for(var i = 0; i < arguments.length; i++)
    {
         column = document.createElement("td");
         column.innerHTML = arguments[i];
         row.appendChild(column);
    }
    document.getElementById("table2").appendChild(row);
}
function ShowDeleteItem()
{
    var row = document.createElement("tr");
    var column;
    for(var i = 0; i < 5; i++)
    {
         column = document.createElement("td");
         column.innerHTML = arguments[i];
         row.appendChild(column);
    }
    column2 = document.createElement("td");
    column3 = document.createElement("td");
    column2.innerHTML = "<div class='col-xs-4'><input type='text' class='form-control' id=" + "'" + arguments[5] + "'" + "placeholder='Quantité à enlever'></div>";
    column3.innerHTML = "<button class='btn btn-default' onclick='DeleteItem(" + arguments[5] + ");' >Retirer</button>";
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
    var ranger = document.getElementById("TxtBoxRanger").value;
    var etagere = document.getElementById("TxtBoxEtagere").value;
    var tablette = document.getElementById("TxtBoxTablette").value;
    var description =  document.getElementById("description").value;
    var quantite = document.getElementById("qt").value;

    if(tablette == "Planché")
    {
        tablette = 0;
    }

    var emplacement = "R" + ranger + "-E" + etagere + "-T" + tablette;

    if(window.JavaApp.CreateItem(upc,emplacement,description,quantite))
    {
        ResetAjouter();
    }
}

function MoveItem()
{
   var id = document.getElementById("id").value;
   var quantite = document.getElementById("qt").value;
   var ranger = document.getElementById("TxtBoxRanger").value;
   var etagere = document.getElementById("TxtBoxEtagere").value;
   var tablette = document.getElementById("TxtBoxTablette").value;

   if(tablette == "Planché")
   {
     tablette = 0;
   }

   var nouvelleEmplacement = "R" + ranger + "-E" + etagere + "-T" + tablette;



   if(window.JavaApp.MoveItem(id,quantite,nouvelleEmplacement))
   {
        ResetDeplacer();
   }


}
function ResetDeplacer()
{
    document.getElementById("id").value = "";
    document.getElementById("qt").value = "";
    document.getElementById("TxtBoxRanger").value = "";
    document.getElementById("TxtBoxEtagere").value = "";
    document.getElementById("TxtBoxTablette").value = "";
}


function ModifyItem()
{
   var itemID = document.getElementById("id").value;
   var description = document.getElementById("description").value;
   alert(itemID);
   if(window.JavaApp.ModifyItem(itemID,description))
   {
      ResetModify();
   }
}

function ResetModify()
{
   document.getElementById("id").value = "";
   document.getElementById("description").value = "";
}


function SetRanger(nbRanger)
{
    document.getElementById("TxtBoxRanger").value = nbRanger;
}
function SetEtagere(nbEtagere)
{
    document.getElementById("TxtBoxEtagere").value = nbEtagere;
}
function SetTablette(nbTablette)
{
    document.getElementById("TxtBoxTablette").value = nbTablette;
}