//Checks the permission and calls the apply permission acording
function CheckPermission()
{
    //The permission counter for all the perms
    var permissionCntr = 0;

    //Variable containing all permissions for a given user
    var permissions = "1001000101000101000000";

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