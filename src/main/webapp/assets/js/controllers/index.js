angular.module('getmedoc',['ngResource'])
	.config(function ($routeProvider) {debugger;
		$routeProvider
			.when('/',{
				templateUrl: 'doclist.html',
				controller: 'SearchDocs'
			});
	})
	.controller('SearchDocs',function($scope,$resource){debugger;
		var Doctors = $resource('/doctors'); 
	})
	.controller('SearchCtrl',function($scope,$resource){
		$scope.onSearch = function() {debugger;
			var Doctors = $resource('doctors');
			$scope.doctorsList = Doctors.get({
						sortBy: 'name',
						order:'asc',
						pageNo:1,
						pageSize: 50
					});
			
			
		}
	});