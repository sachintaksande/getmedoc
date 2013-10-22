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
						name: $scope.search,
						city:'nagpur',
						zip:'440024',
						spcl:'mbbs',
						sortBy: 'name',
						order:'asc',
						sortField:'name',
						sortOrder: 'desc',
						pageNo:0,
						pageSize: 50
					});
			
			
		}
	});