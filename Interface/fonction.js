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
   document.getElementById("id").value = " ";
   document.getElementById("description").value = " ";
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

// -----------------MODULE COMMANDE -------------------------------------------------

//Cette fonction appelle l’application java pour créer une commande
function CreateCommande()
{
   var upcCommande = document.getElementById("upcCommande").value;
   var qtCommande = document.getElementById("qtCommande").value;
   var descriptionCommande = document.getElementById("descriptionCommande").value;

   if(window.JavaApp.CreateCommande(upcCommande,qtCommande,descriptionCommande))
   {
      ResetCreateCommande();
   }
}

//Cette fonction vide les champs d'envoi de commande
function ResetCreateCommande()
{
   document.getElementById("upcCommande").value = " ";
   document.getElementById("qtCommande").value = " ";
   document.getElementById("descriptionCommande").value = " ";
}

//Cette fonction vide les champs de recherche
function ResetRechercheCommande()
{
   document.getElementById("name").value = " ";
   document.getElementById("upc").value = " ";
   document.getElementById("etatCommande").value = " ";
}

//Cette fonction trouve les commandes a afficher
// son nom devrait etre AfficherToutCommande
function SubmitCommande()
{
    upc = document.getElementById("upc").value;
    etat = document.getElementById("etatCommande").value;
    name = document.getElementById("name").value;
    myNode = document.getElementById("table1");
    retardCheckBox = document.getElementById("retard");

    //Deletes all existing entries
    while (myNode.firstChild) {
        myNode.removeChild(myNode.firstChild);
    }

    if(upc == "")
    {
        upc = -1;
    }

    if (name == "")
    {
     name = "-1";
    }

    if (etat == "")
    {
     etat = -1;
    }

  if (retardCheckBox.checked == true){
    retard = true;
  } else {
    retard = false;
  }

    window.JavaApp.ListAllCommande(upc,name,etat,retard);
}

function SetRangerC(id,nbRanger)
{
    document.getElementById("r"+id).value = nbRanger;
}
function SetEtagereC(id,nbEtagere)
{
    document.getElementById("e"+id).value = nbEtagere;
}
function SetTabletteC(id,nbTablette)
{
    document.getElementById("t"+id).value = nbTablette;
}

function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;

    return [year, month, day].join('-');
}

//Cette fonction fait afficher les commandes
function ShowCommandeItem()
{
    var row = document.createElement("tr");
    var column;
    for(var i = 0; i < 6; i++)
    {

      if (i==4)
      {
         var dateLivraison = arguments[i];

         var d = new Date();
         var dCommande = new Date(dateLivraison);

         if (dCommande > d)
         {
          column = document.createElement("td");
          column.innerHTML = arguments[i];
          row.appendChild(column);
         }
         else
         {
            column = document.createElement("td");
            column.innerHTML = "<p style='color:red;'>"+arguments[i]+"</p>";
            row.appendChild(column);
         }

      }else
      {
       column = document.createElement("td");
       column.innerHTML = arguments[i];
       row.appendChild(column);
      }
    }
    column2 = document.createElement("td");
    column3 = document.createElement("td");

    if (arguments[5] != 2)
    {
        column2.innerHTML = "<div class='btn-group'> <div class='dropdown'> <button class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown'>Rangée<span class='caret'></span></button><ul class='dropdown-menu'> <li><a href='#' onclick='SetRangerC("+ arguments[0]+","+"this.innerHTML)'>0</a></li><li><a href='#' onclick='SetRangerC("+ arguments[0]+","+"this.innerHTML)'>1</a></li><li><a href='#' onclick='SetRangerC("+ arguments[0]+","+"this.innerHTML)'>2</a></li><li><a href='#' onclick='SetRangerC("+ arguments[0]+","+"this.innerHTML)'>3</a></li></ul> <div> <input id="+"'r"+ arguments[0]+"'"+"class='form-control' type='text' size='6' readonly></div> </div> </div><div class='btn-group'> <div class='dropdown'> <button class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown'>Étagère<span class='caret'></span></button> <ul class='dropdown-menu'> <li><a href='#' onclick='SetEtagereC("+ arguments[0]+","+"this.innerHTML)'>0</a></li><li><a href='#' onclick='SetEtagereC("+ arguments[0]+","+"this.innerHTML)'>1</a></li><li><a href='#' onclick='SetEtagereC("+ arguments[0]+","+"this.innerHTML)'>2</a></li><li><a href='#' onclick='SetEtagereC("+ arguments[0]+","+"this.innerHTML)'>3</a></li><li><a href='#' onclick='SetEtagereC("+ arguments[0]+","+"this.innerHTML)'>4</a></li><li><a href='#' onclick='SetEtagereC("+ arguments[0]+","+"this.innerHTML)'>5</a></li><li><a href='#' onclick='SetEtagereC("+ arguments[0]+","+"this.innerHTML)'>6</a></li><li><a href='#' onclick='SetEtagereC("+ arguments[0]+","+"this.innerHTML)'>7</a></li></ul> <div> <input id="+"'e"+ arguments[0]+"'"+ "class='form-control' type='text' size='6' readonly></div> </div> </div><div class='btn-group'> <div class='dropdown'> <button class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown'>Tablette<span class='caret'></span></button><ul class='dropdown-menu'> <li><a href='#' onclick='SetTabletteC("+ arguments[0]+","+"this.innerHTML)'>Planché</a></li><li><a href='#' onclick='SetTabletteC("+ arguments[0]+","+"this.innerHTML)'>1</a></li><li><a href='#' onclick='SetTabletteC("+ arguments[0]+","+"this.innerHTML)'>2</a></li><li><a href='#' onclick='SetTabletteC("+ arguments[0]+","+"this.innerHTML)'>3</a></li><li><a href='#' onclick='SetTabletteC("+ arguments[0]+","+"this.innerHTML)'>4</a></li><li><a href='#' onclick='SetTabletteC("+ arguments[0]+","+"this.innerHTML)'>5</a></li></ul> <div> <input id="+"'t"+ arguments[0]+"'"+ "class='form-control' type='text' size='6' readonly></div> </div> </div>";
        column3.innerHTML = "<button class='btn btn-default' onclick='RecevoirCommande(" + arguments[0] +");' >Recevoir Commande</button>";
    }

    row.appendChild(column);
    row.appendChild(column2);
    row.appendChild(column3);

    document.getElementById("table1").appendChild(row);
}

//Cette fonction reçoit une commande
function RecevoirCommande(id)
{
   var ranger = document.getElementById("r"+id).value;
   var etagere = document.getElementById("e"+id).value;
   var tablette = document.getElementById("t"+id).value;

   if (ranger != "")
   {
    if (etagere != "")
    {
        if (tablette != "")
        {
             if(tablette == "Planché")
               {
                 tablette = 0;
               }

               var nouvelleEmplacement = "R" + ranger + "-E" + etagere + "-T" + tablette;

               if(window.JavaApp.RecevoirCommande(id,nouvelleEmplacement))
               {
                 //refresh
               }
        }
        else
        {
            alert("la tablette est invalid");
        }
    }
    else
    {
        alert("l'etagere est invalid");
    }
   }
   else
   {
     alert("la ranger est invalid");
   }
}

//--------------------FIN MODULE COMMANDE---------------------------------------

