function traerMaquinas(){
    $.ajax({
        url:"http://localhost:8080/api/Machine/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuestaM){
            console.log(respuestaM);
            renderMaquinas(respuestaM)
        }
    });
}
function renderMaquinas(itemsM){
    let myTable = "<table>";
    for(i = 0; i < itemsM.length; i++){
        myTable+="<tr>";
        myTable+="<td>"+"|"+itemsM[i].name+"</td>";
        myTable+="<td>"+"|"+itemsM[i].brand+"</td>";
        myTable+="<td>"+"|"+itemsM[i].year+"</td>";
        myTable+="<td>"+"|"+itemsM[i].description+"</td>";
        myTable+="<td>"+"|"+itemsM[i].category.name+"</td>";
        myTable+="<td> <button onclick='borrarMaquina("+itemsM[i].id+")'>Borrar</button>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#maquinas").empty();
    $("#maquinas").append(myTable);
}


function traerCategorias(){
    $.ajax({
        url:"http://localhost:8080/api/Category/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuestaC){
            console.log(respuestaC);
            renderCategorias(respuestaC)
        }
    });
}

function renderCategorias(itemsC){
    let myTable = "<table>";
    for(i = 0; i < itemsC.length; i++){
        for(j = 0; j < itemsC[i].machines.length; j++){
        myTable+="<tr>";
        myTable+="<td>"+"|"+itemsC[i].name+"</td>";
        myTable+="<td>"+"|"+itemsC[i].description+"</td>";
        myTable+="<td>"+"|"+itemsC[i].machines[j].name+"</td>";
        myTable+="<td> <button onclick='borrarMaquina("+itemsC[i].id+")'>Borrar</button>";
        myTable+="</tr>";
        }
    }
    myTable+="</table>";
    $("#categorias").append(myTable);
}




function guardarMaquina(){
        let myData={
            brand:$("#brand").val(),
            year:$("#year").val(),
            category:{id:$("#category").val()},
            name:$("#name").val(),
            description:$("#description").val(),
        };
        let dataToSend=JSON.stringify(myData);
        console.log(myData);
        console.log(dataToSend);
        $.ajax({
           url:"http://localhost:8080/api/Machine/save",
                   type:"POST",
                   data:dataToSend,
                   contentType:"application/JSON",
                   datatype:"JSON",
                   success:function(respuesta){
                    $("#maquinas").empty();
                    $("#brand").val("");
                    $("#year").val("");
                    $("#category").val("");
                    $("#name").val("");
                    $("#description").val("");
                    traerMaquinas();
                    alert("se ha guardado el dato");
                   }
        });
}


function editarInformacion(){
        let myData={
            brand:$("#brand").val(),
            model:$("#model").val(),
            category:$("#category").val(),
            name:$("#name").val(),
        };
        console.log(myData);
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:"https://gf486fc8ac6c168-my002hgc53w71fgr.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/gym/gym",
            type:"PUT",
            data:dataToSend,
            contentType:"application/JSON",
            datatype:"JSON",
            success:function(respuesta){
                $("#resultado").empty();
                $("#id").val("");
                $("#brand").val("");
                $("#model").val("");
                $("#category").val("");
                $("#name").val("");
                traerMaquinas();
                alert("se ha actualizado");
            }
        });
}


function borrarMaquina(idElemento){
    let myData={
        id:idElemento
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://localhost:8080/api/Machine/delete",
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            traerMaquinas();
            alert("se ha eliminado")
        }
    });

}
