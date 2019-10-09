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
function Alert(msg)
{
    window.alert(msg);
}
