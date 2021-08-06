const re = angular.module("role-app", []);
re.controller("role-ctrl",function($scope,$http){
    $scope.form = {}
    $scope.create= function (){
        var item=angular.copy($scope.form);
        $http.post("/rest/register",item).then(resp => {
            console.log("Success",resp);
        }).catch(err => {
            console.log("Error",err);
        })
    }
})