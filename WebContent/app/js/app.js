var app = angular.module('javaFiddle', []);

app.controller('compilationController', function($scope, $http,
		compilationControllerService) {

	$scope.compile = function() {

		if ($scope.javaSourceCode.className == null) {
			$scope.javaSourceCode.className = "Unnamed";        
		}

		compilationControllerService.compile($scope.javaSourceCode).then(
				function(data) {

					$scope.console = data;
					if (data.errorFlag) {
						$scope.errorStatus = "Error : Something went Wrong";
					} else {
						$scope.errorStatus = "";
					}

				});

	}

});

app.service("compilationControllerService", [ "$http", "$q",
		function($http, $q) {

			this.compile = function(javaSourceCode) {

				var url = "http://localhost:8002/JavaFiddle/execute";
				var defer = $q.defer();

				$http.post(url, javaSourceCode).success(function(data) {

					defer.resolve(data);
				})

				return defer.promise;

			};
		} ])