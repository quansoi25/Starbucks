const app = angular.module("shopping-cart-app", []);
app.controller("shopping-cart-ctrl", function($scope, $http) {
	$scope.cart = {
		items: [],
		add(productId) {
			var item = this.items.find(item => item.productId == productId);
			if (item) {
				item.qty++;
				this.saveToLocalStorage();
			} else {
				var url = `/rest/products/${productId}`;
				$http.get(url).then(resp => {
					resp.data.qty = 1;
					this.items.push(resp.data);
					this.saveToLocalStorage();
				})
			}
		},
		get Count() {
			return this.items
				.map(item=>item.qty)
				.reduce((total,qty)=>total+=qty,0);
		},
		get Amount(){
			return this.items
				.map(item=>item.qty*item.unitPrice)
				.reduce((total,qty)=>total+=qty,0);
		},
		saveToLocalStorage() {
			var json = JSON.stringify(angular.copy(this.items));
			localStorage.setItem("cart", json);
		},
		loadFromLocalStorage(){
            var json=localStorage.getItem("cart");
            this.items=json ? JSON.parse(json) : [];
		},
        remove(productId){
            var index=this.items.findIndex(item => item.productId==productId);
            this.items.splice(index,1);
            this.saveToLocalStorage();
        },
        clear(){
            this.items=[];
            this.saveToLocalStorage(); 
        }
	}
	$scope.cart.loadFromLocalStorage();

	$scope.order={
		createDate:new Date(),
		address:"",
		account:{username: $("#username").text()},
		get orderDetails(){
			return $scope.cart.items.map(item=>{
				return {
					product:{productId:item.productId},
					unitPrice:item.unitPrice,
					quantity:item.qty
				}
			});
		},
		purchase(){
			var order=angular.copy(this);
			$http.post("/rest/orders",order).then(resp=>{
				alert("Order success");
				$scope.cart.clear();
				location.href="/order/detail/"+resp.data.id;
			}).catch(error=>{
				alert("Order failure")
				console.log(error);
			})
		}
	}
	$scope.form = {}
    $scope.create= function (){
        var item=angular.copy($scope.form);
        $http.post("/rest/register",item).then(resp => {
			alert("Registration successful")
			location.href="/security/login/form";
            console.log("Success",resp);
        }).catch(err => {
            console.log("Error",err);
        })
    }
})