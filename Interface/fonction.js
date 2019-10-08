function afficheDate(){
	jours = new Array('Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi'); 
	mois = new Array('Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Août',
					 'Septembre', 'Octobre', 'Décembre');
     var aujourdhui = new Date(); 
     var result = jours[aujourdhui.getDay()] + ", le " + aujourdhui.getDate() + " " + 
	 mois[aujourdhui.getMonth()] + " " + aujourdhui.getFullYear(); 
	document.writeln(result);
}
function exit()
{
    window.JavaApp.exit();
}

function afficherTableau()
{
// on cree le tableau bleu, contenant les lignes
var grille = new Array();
grille[1]="Id";
grille[2]="Nom";
grille[3]="Description";
grille[4]="Poids";
grille[5]="Volume";
//"Nom","Description","Poids","Volume"
// on cree les lignes (tableau vert) les unes après les autres
/*
for(var i=0; i<4; i++)
   grille[i] = new Array();
*/

// on parcourt les lignes...
for(var i=0; i<4; i++)
   // ... et dans chaque ligne, on parcourt les cellules
   for(var j=0; j<4; j++)
      grille[i][j] = 0;

      //affichage
      for(var i=0; i<4; i++)
         for(var j=0; j<4; j++)
            document.writeln("Case "+ i + "-" + j +" : "+ grille[i][j]);


}
function List()
{
    alert("This is an alert");
    myNode = document.getElementById("table1");
    while (myNode.firstChild) {
        myNode.removeChild(myNode.firstChild);
    }
    if(document.getElementById("chkBoxTout").checked)
    {
        window.JavaApp.ListAllItems();
    }

}
function Reset()
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
function Alert()
{
    alert(arguments[0]);
}
