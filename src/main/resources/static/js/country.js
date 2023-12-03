let opration = 0;

$(document).ready(function () {
    $("#detailContains").css("display", "none");
    // when click the create button, show the detailContains
    $("#selCreate").on('click', function () {
        // clear all input
        $(':input', '#frmDetail')
            .not(':button, :submit, :reset, :hidden')
            .val(''); 
        // show the detailContains
        $("#detailContains").css("display", "block");
        // hide the queryContainer
        $("#queryContainer").css("display", "none");
    });

    // when click the update button, show the queryContainer
    $("#selUpdate, #selDelete").on('click', function () {
        // show the queryContainer
        $("#queryContainer").css("display", "block");
        // hide the detailContains
        $("#detailContains").css("display", "none");
        // set the form action for update
        $("#frmDetail").attr("action", "/UpdateCountry");
        
        if ($(this).attr("id") == "selUpdate") {
			opration = 1;
			
		} else {
			opration = 2;
			
		}
    });

    // when click the return button, hide the detailContains
    $("#returnBtn").on('click', function () {
        // show the queryContainer
        // $("#queryContainer").css("display", "block");
        // hide the detailContains
        $("#detailContains").css("display", "none");
    });


	// 更新button押下
    $("#queryBtn").on('click', function () {
        // use ajax to post data to controller
        // recived the data from controller with json
        // show the data in the detailContains
        
        $.ajax({
            type: "POST",
            url: "/country/getCountry",        //  <- controller function name
            data: $("#frmSearch").serialize(),
            dataType: 'json',
            success: function (data) {
                $("#detailContains").css("display", "block");
                // show the data in the detailContains
                $("#countryCodeInput").val(data.mstcountrycd);
                $("#countryNameInput").val(data.mstcountrynanme);
            },
            error: function (e) {
                alert("error");
            }
        });
       
		});
    
    $("#updateBtn").on('click', function () {          
        // use ajax to post data to controller
        // recived the data from controller with json
        // show the data in the detailContains
        if (opration == 1) {
			 $.ajax({
            type: "POST",
            url: "/country/updCountry",
            data: $("#frmDetail").serialize(),
            success: function (data) {
                alert("更新成功");
            },
            error:function(){
				alert("更新失败");
			}
        });
		} else if(opration == 2) {
			 $.ajax({
            type: "POST",
            url: "/country/delCountry",
            data: $("#frmDetail").serialize(),
            success: function (data) {
                alert("删除成功");
                
            },
            error:function(){
				alert("删除失败");
			}
        });
		} else {
			$.ajax({
            type: "POST",
            url: "/country/loginCountry",
            data: $("#frmDetail").serialize(),
            success: function (data) {
                alert("添加成功");
            },
            error:function(){
				alert("添加失败");
			}
        });
			
		}
    });
    
});