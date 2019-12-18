function ShowBackups(backupName, index)
{
    var row = document.createElement("tr");
    var column;
    column = document.createElement("td");
    column.innerHTML = backupName;
    row.appendChild(column);
    column2 = document.createElement("td");
    column2.innerHTML = '<button class="btn btn-default" onclick="Restore(' + index + ');" >Revenir à ce backup</button>';
    row.appendChild(column);
    row.appendChild(column2);
    document.getElementById("table1").appendChild(row);
}
function Restore(index)
{
    if(confirm("Voulez-vous vraiment restaurer ce backup?") && confirm("Êtes vous certain? (Cette opération peut prendre plusieurs minutes..)"))
    {
        window.JavaApp.Restore(index);
    }
}
function clearBackups()
{
myNode = document.getElementById("table1");
    while (myNode.firstChild) {
        myNode.removeChild(myNode.firstChild);
    }
}