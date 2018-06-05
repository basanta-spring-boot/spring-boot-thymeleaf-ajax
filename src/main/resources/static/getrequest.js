$(document).ready(
		function() {

			// GET REQUEST
			$("#getAllUser").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});

			// DO GET
			function ajaxGet() {
				$.ajax({
					type : "GET",
					url : window.location + "getUsers",
					success : function(result) {
						if (result.status == "success") {
							$('#getResultDiv ul').empty();
							var custList = "";
							$.each(result.object, function(i, user) {
								var user = "- User with Id = " + user.id
										+ ", firstname = " + user.name
										+ ", email = " + user.email + "<br>";
								$('#getResultDiv .list-group').append(user)
							});
							console.log("Success: ", result);
						} else {
							$("#getResultDiv").html("<strong>Error</strong>");
							console.log("Fail: ", result);
						}
					},
					error : function(e) {
						$("#getResultDiv").html("<strong>Error</strong>");
						console.log("ERROR: ", e);
					}
				});
			}
		})
