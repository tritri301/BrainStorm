//Checks the permission and calls the apply permission acording
function CheckPermission()
{
    //The permission counter for all the perms
    var permissionCntr = 0;

    //Variable containing all permissions for a given user
    var permissions = "1101110000000000000000";

    var logoCoolPlay = document.getElementById("logo");
    var catalogue = document.getElementById("catalogue");
    var deconnexion = document.getElementById("deconnexion");
    var menuPrincipal = document.getElementById("sectionSousMenu");
    var boutonAjouter = document.getElementById("SubmitAjouter");

    permissionCntr = VerifyNode(logoCoolPlay, permissionCntr, permissions, 1);
    permissionCntr = VerifyNode(catalogue, permissionCntr, permissions, 2);
    permissionCntr = VerifyNode(deconnexion, permissionCntr, permissions, 1);
    permissionCntr = VerifyNode(menuPrincipal, permissionCntr, permissions, 6);
    permissionCntr = VerifyNode(boutonAjouter, permissionCntr, permissions, 2);
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
//the defaultNumber is the number of child node a parent
//is supposed to have, so that if the parent isn't there, we can
//update currentPermissionIndex to check the next permission.
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