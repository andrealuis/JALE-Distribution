function mostrarMap(){
    var sty=document.getElementById('map').style.display;
    if(sty== 'none'){

        document.getElementById('map').style.display = 'block';
    }
    else{
        document.getElementById('map').style.display = 'none';
    }
}