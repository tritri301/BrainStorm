
function CheckConnexion()
{
    var user = document.getElementById("user").value;
    var password = document.getElementById("password").value;

    if(!window.JavaApp.CheckConnexion(user, password))
    {
        alert("Email ou mot de passe incorrect!");
    }
    else
    {
        window.location.href = "index.html";
    }
}

function CheckPermission()
{
    path = document.location.pathname;
    directory = path.substring(path.indexOf('/'), path.lastIndexOf('/'));
    if(!window.JavaApp.isUserConnected() && window.location.pathname != directory + "/connexion.html")
    {
        window.location.href = "connexion.html";
    }
    //The permission counter for all the perms
    var permissionCntr = 0;

    //Variable containing all permissions for a given user
    //var permissions = window.JavaApp.CheckPermission();
    var permissions = window.JavaApp.CheckPermission();

    //Getting all the parents of the buttons we want permission on
    var logoCoolPlay = document.getElementById("logo");
    var catalogue = document.getElementById("catalogue");
    var deconnexion = document.getElementById("deconnexion");
    var menuPrincipal = document.getElementById("sectionSousMenu");
    var boutonAjouter = document.getElementById("SubmitAjouter");
    var boutonSupprimer = document.getElementById("boutonSupprimer");
    var boutonDeplacer = document.getElementById("boutonDeplacer");
    var boutonModifier = document.getElementById("boutonModifier");
    var boutonLister = document.getElementById("boutonLister");

    //Setting the permissions on these buttons, meaning, we deactivate the ones the user
    //Shouldn't have access to.
    permissionCntr = VerifyNode(logoCoolPlay, permissionCntr, permissions, 1);
    permissionCntr = VerifyNode(catalogue, permissionCntr, permissions, 2);
    permissionCntr = VerifyNode(deconnexion, permissionCntr, permissions, 1);
    permissionCntr = VerifyNode(menuPrincipal, permissionCntr, permissions, 6);
    permissionCntr = VerifyNode(boutonAjouter, permissionCntr, permissions, 2);
    permissionCntr = VerifyNode(boutonSupprimer, permissionCntr, permissions, 2);
    permissionCntr = VerifyNode(boutonDeplacer, permissionCntr, permissions, 2);
    permissionCntr = VerifyNode(boutonModifier, permissionCntr, permissions, 2);
    permissionCntr = VerifyNode(boutonLister, permissionCntr, permissions, 2);
}

//This function detects which tag we have, and apply
//the dactivation according to that.
function DisableTag(domNode)
{
    if(domNode.tagName == "A") //disables the <a> tag
    {
        domNode.href = "#";
        if(domNode.childNodes[0].tagName == "IMG")
        {
            domNode.childNodes[0].style.filter = "grayscale(100%)";
        }
    }
    else if(domNode.tagName == "INPUT" || domNode.tagName == "BUTTON") //disables the <input> tag
    {
        domNode.disabled = true;
    }
}

//Verifies if the node is currently displayed, if it is, we can
//loop into it, or check it's permission, else, we just
//increment permissionCntr and skip that permission check.
//The defaultNumber variable is the ammount of permission is certain parent is allowed
//to take, meaning that if we know a parent might
//have another child button in the future, we can set the defaultNumber
//to allow that parent to have more buttons in the future
function VerifyNode(parentNode, currentPermissionIndex, permissions, defaultNumber)
{
    if(parentNode == null)
    {
        currentPermissionIndex += defaultNumber; //if no parent is detected, updates the index
    }
    else
    {
        LoopNode(parentNode.childNodes, currentPermissionIndex, permissions);
        currentPermissionIndex += defaultNumber;
    }
    return currentPermissionIndex;
}

//Loops though a node and sends the nodes that apply for permission
function LoopNode(domNode, currentPermissionIndex, permissions)
{
    for(i = 0; i < domNode.length; i++)
    {
        if(domNode[i].tagName == "A" || domNode[i].tagName == "INPUT" || domNode[i].tagName == "BUTTON")
        {
            if(permissions[currentPermissionIndex] == "0")
            {
                DisableTag(domNode[i]);
            }
            currentPermissionIndex++;
        }
    }
}