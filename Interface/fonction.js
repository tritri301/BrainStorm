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
function list()
{
    window.JavaApp.list();
}
function Test()
{
    var row = document.createElement("tr");
    var column1 = document.createElement("td");
    var column2 = document.createElement("td");
    var column3 = document.createElement("td");
    var column4 = document.createElement("td");
    column1.innerHTML = "test1";
    column2.innerHTML = "test2";
    column3.innerHTML = "test3";
    column4.innerHTML = "test4";
    row.appendChild(column1);
    row.appendChild(column2);
    row.appendChild(column3);
    row.appendChild(column4);
    document.getElementById("table1").appendChild(row);
}