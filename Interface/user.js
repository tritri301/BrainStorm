function CreateUser()
{
    var numEmpl = document.getElementById("NumEmpl");
    var email = document.getElementById("Email");
    var password = document.getElementById("password");
    var poste = document.getElementById("Poste");
    var lastName = document.getElementById("LastName");
    var firstName = document.getElementById("FirstName");
    var address = document.getElementById("Address");
    var idRole = document.getElementById("idRole");

    window.JavaApp.CreateUser(numEmpl, email, password, poste, lastName, firstName, address, idRole);
}