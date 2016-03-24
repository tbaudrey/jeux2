function afficheSablier(){
    $('img').show();
}

function clicSurBouton(){
    afficheSablier();
    
    //Req ajax -> maj zone contenu
    $('#contenu').load('_contenu.html')
    
    cacheSablier();
}

function cacheSablier(){
    $('img').hide();
}

function sablier(){
    $('img').fadeToggle();
}

function init(){
    $('#logger').load('_non_logger.jsp');
}

function inscription(){
    $('#non_logger').load('inscription.jsp');
}

function logger(){
    $('#logger').load('_logger.jsp');
}

function logout(){
    $('#logger').load('LogoutServlet');
    $('#logger').load('_non_logger.jsp');
}


function nouvellePartie(){
    $('#contenu').load('_nouvellePartie.jsp');
}

function partiesEnCours(){
    $('#contenu').load('_partiesEnCours.jsp');
}