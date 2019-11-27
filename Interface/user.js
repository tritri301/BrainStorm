function CreateUser()
{
    var numEmpl = document.getElementById("NumEmpl").value;
    var email = document.getElementById("Email").value;
    var password = document.getElementById("password").value;
    var poste = document.getElementById("Poste").value;
    var lastName = document.getElementById("LastName").value;
    var firstName = document.getElementById("FirstName").value;
    var address = document.getElementById("Address").value;
    var idRole = document.getElementById("idRole").value;

    window.JavaApp.CreateUser(numEmpl, email, password, poste, lastName, firstName, address, idRole);
}
function SearchUser()
{
    var numEmpl = document.getElementById("NumEmpl").value;
    window.JavaApp.FindUserById(numEmpl);
}
function ShowUser()
{
    document.getElementById("Email").value = arguments[0];
    document.getElementById("password").value = arguments[1];
    document.getElementById("Poste").value = arguments[2];
    document.getElementById("LastName").value = arguments[3];
    document.getElementById("FirstName").value = arguments[4];
    document.getElementById("Address").value = arguments[5];
    document.getElementById("idRole").value = arguments[6];

    document.getElementById("Email").disabled = false;
    document.getElementById("password").disabled = false;
    document.getElementById("Poste").disabled = false;
    document.getElementById("LastName").disabled = false;
    document.getElementById("FirstName").disabled = false;
    document.getElementById("Address").disabled = false;
    document.getElementById("idRole").disabled = false;

    document.getElementById("submit").onclick = ModifyUser;
}
function ModifyUser()
{
    var numEmpl = document.getElementById("NumEmpl").value;
    var email = document.getElementById("Email").value;
    var password = document.getElementById("password").value;
    var poste = document.getElementById("Poste").value;
    var lastName = document.getElementById("LastName").value;
    var firstName = document.getElementById("FirstName").value;
    var address = document.getElementById("Address").value;
    var idRole = document.getElementById("idRole").value;

    window.JavaApp.ModifyUser(numEmpl, email, password, poste, lastName, firstName, address, idRole);
}