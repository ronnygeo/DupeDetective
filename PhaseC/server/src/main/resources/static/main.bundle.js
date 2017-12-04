webpackJsonp(["main"],{

/***/ "../../../../../src/$$_lazy_route_resource lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "../../../../../src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "../../../../../src/app/app-routing.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppRoutingModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__components_assignmentlist_assignmentlist_component__ = __webpack_require__("../../../../../src/app/components/assignmentlist/assignmentlist.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__components_home_home_component__ = __webpack_require__("../../../../../src/app/components/home/home.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__components_submissionlist_submissionlist_component__ = __webpack_require__("../../../../../src/app/components/submissionlist/submissionlist.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__components_uploadsubmission_uploadsubmission_component__ = __webpack_require__("../../../../../src/app/components/uploadsubmission/uploadsubmission.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__components_login_login_component__ = __webpack_require__("../../../../../src/app/components/login/login.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__components_register_register_component__ = __webpack_require__("../../../../../src/app/components/register/register.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__components_report_report_component__ = __webpack_require__("../../../../../src/app/components/report/report.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__components_assignmentnew_assignmentnew_component__ = __webpack_require__("../../../../../src/app/components/assignmentnew/assignmentnew.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__components_comparedocuments_comparedocuments_component__ = __webpack_require__("../../../../../src/app/components/comparedocuments/comparedocuments.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__auth_guard__ = __webpack_require__("../../../../../src/app/auth.guard.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};












// Defining routes
var routes = [
    { path: 'assignments', component: __WEBPACK_IMPORTED_MODULE_2__components_assignmentlist_assignmentlist_component__["a" /* AssignmentListComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_11__auth_guard__["a" /* AuthGuardGrader */]] },
    { path: 'assignments/new', component: __WEBPACK_IMPORTED_MODULE_9__components_assignmentnew_assignmentnew_component__["a" /* AssignmentNewComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_11__auth_guard__["a" /* AuthGuardGrader */]] },
    { path: 'assignment/:assignmentId/submissions', component: __WEBPACK_IMPORTED_MODULE_4__components_submissionlist_submissionlist_component__["a" /* SubmissionListComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_11__auth_guard__["a" /* AuthGuardGrader */]] },
    { path: 'submissions', component: __WEBPACK_IMPORTED_MODULE_4__components_submissionlist_submissionlist_component__["a" /* SubmissionListComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_11__auth_guard__["a" /* AuthGuardGrader */]] },
    { path: 'compare', component: __WEBPACK_IMPORTED_MODULE_10__components_comparedocuments_comparedocuments_component__["a" /* ComparedocumentsComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_11__auth_guard__["a" /* AuthGuardGrader */]] },
    { path: 'reports', component: __WEBPACK_IMPORTED_MODULE_8__components_report_report_component__["a" /* ReportComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_11__auth_guard__["a" /* AuthGuardGrader */]] },
    { path: 'assignment/:assignmentId/submission/:submissionId/reports', component: __WEBPACK_IMPORTED_MODULE_8__components_report_report_component__["a" /* ReportComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_11__auth_guard__["a" /* AuthGuardGrader */]] },
    { path: 'submission/:assignmentId', component: __WEBPACK_IMPORTED_MODULE_4__components_submissionlist_submissionlist_component__["a" /* SubmissionListComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_11__auth_guard__["a" /* AuthGuardGrader */]] },
    { path: 'submissions/new', component: __WEBPACK_IMPORTED_MODULE_5__components_uploadsubmission_uploadsubmission_component__["a" /* UploadSubmissionComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_11__auth_guard__["b" /* AuthGuardStudent */]] },
    { path: '', component: __WEBPACK_IMPORTED_MODULE_3__components_home_home_component__["a" /* HomeComponent */] },
    { path: 'login', component: __WEBPACK_IMPORTED_MODULE_6__components_login_login_component__["a" /* LoginComponent */] },
    { path: 'register', component: __WEBPACK_IMPORTED_MODULE_7__components_register_register_component__["a" /* RegisterComponent */] },
    { path: '', redirectTo: 'login', pathMatch: 'full' }
];
var AppRoutingModule = (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["K" /* NgModule */])({
            imports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["e" /* RouterModule */].forRoot(routes)],
            exports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["e" /* RouterModule */]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "../../../../../src/app/app.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<!--The content below is only a placeholder and can be replaced.-->\n<app-navbar></app-navbar>\n\n<router-outlet *ngIf=\"isHome()\"></router-outlet>\n\n<div class=\"content-wrapper\" *ngIf=\"!isHome()\">\n  <div class=\"container\">\n    <div *ngIf=\"message\" [ngClass]=\"{ 'alert': message, 'alert-success': message.type === 'success', 'alert-danger': message.type === 'error' }\">{{message.text}}</div>\n    <router-outlet></router-outlet>\n  </div>\n</div>\n\n"

/***/ }),

/***/ "../../../../../src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__services_alert_service__ = __webpack_require__("../../../../../src/app/services/alert.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var AppComponent = (function () {
    function AppComponent(router, alertService) {
        this.router = router;
        this.alertService = alertService;
    }
    /**
     * On page load
     */
    AppComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.router.events.subscribe(function (event) {
            if (event instanceof __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* NavigationEnd */]) {
                console.log("Current Route: " + event.url);
                _this.currentRoute = event.url;
            }
        });
        this.alertService.getMessage().subscribe(function (message) { _this.message = message; });
    };
    /**
     * returns if the page is home or not
     * @returns {boolean}
     */
    AppComponent.prototype.isHome = function () {
        return (this.currentRoute === "" || this.currentRoute === "/");
    };
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
            selector: 'app-root',
            template: __webpack_require__("../../../../../src/app/app.component.html"),
            styles: [__webpack_require__("../../../../../src/app/app.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_router__["d" /* Router */], __WEBPACK_IMPORTED_MODULE_2__services_alert_service__["a" /* AlertService */]])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "../../../../../src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("../../../platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__app_component__ = __webpack_require__("../../../../../src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__components_assignmentlist_assignmentlist_component__ = __webpack_require__("../../../../../src/app/components/assignmentlist/assignmentlist.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__components_uploadsubmission_uploadsubmission_component__ = __webpack_require__("../../../../../src/app/components/uploadsubmission/uploadsubmission.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__components_submissionlist_submissionlist_component__ = __webpack_require__("../../../../../src/app/components/submissionlist/submissionlist.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__services_assignment_service__ = __webpack_require__("../../../../../src/app/services/assignment.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__components_home_home_component__ = __webpack_require__("../../../../../src/app/components/home/home.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__ng_bootstrap_ng_bootstrap__ = __webpack_require__("../../../../@ng-bootstrap/ng-bootstrap/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__components_report_report_component__ = __webpack_require__("../../../../../src/app/components/report/report.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__services_report_service__ = __webpack_require__("../../../../../src/app/services/report.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__services_user_service__ = __webpack_require__("../../../../../src/app/services/user.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__services_submission_service__ = __webpack_require__("../../../../../src/app/services/submission.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15__components_navbar_navbar_component__ = __webpack_require__("../../../../../src/app/components/navbar/navbar.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_16__components_login_login_component__ = __webpack_require__("../../../../../src/app/components/login/login.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_17__components_register_register_component__ = __webpack_require__("../../../../../src/app/components/register/register.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_18__services_alert_service__ = __webpack_require__("../../../../../src/app/services/alert.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_19__components_comparedocuments_comparedocuments_component__ = __webpack_require__("../../../../../src/app/components/comparedocuments/comparedocuments.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_20__components_assignmentnew_assignmentnew_component__ = __webpack_require__("../../../../../src/app/components/assignmentnew/assignmentnew.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_21__app_routing_module__ = __webpack_require__("../../../../../src/app/app-routing.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_22__auth_guard__ = __webpack_require__("../../../../../src/app/auth.guard.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_23__services_analytics_service__ = __webpack_require__("../../../../../src/app/services/analytics.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
























/**
 * Main angular module
 */
var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["K" /* NgModule */])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_3__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_15__components_navbar_navbar_component__["a" /* NavbarComponent */],
                __WEBPACK_IMPORTED_MODULE_8__components_home_home_component__["a" /* HomeComponent */],
                __WEBPACK_IMPORTED_MODULE_4__components_assignmentlist_assignmentlist_component__["a" /* AssignmentListComponent */],
                __WEBPACK_IMPORTED_MODULE_20__components_assignmentnew_assignmentnew_component__["a" /* AssignmentNewComponent */],
                __WEBPACK_IMPORTED_MODULE_6__components_submissionlist_submissionlist_component__["a" /* SubmissionListComponent */],
                __WEBPACK_IMPORTED_MODULE_5__components_uploadsubmission_uploadsubmission_component__["a" /* UploadSubmissionComponent */],
                __WEBPACK_IMPORTED_MODULE_11__components_report_report_component__["a" /* ReportComponent */], __WEBPACK_IMPORTED_MODULE_15__components_navbar_navbar_component__["a" /* NavbarComponent */], __WEBPACK_IMPORTED_MODULE_16__components_login_login_component__["a" /* LoginComponent */], __WEBPACK_IMPORTED_MODULE_17__components_register_register_component__["a" /* RegisterComponent */],
                __WEBPACK_IMPORTED_MODULE_19__components_comparedocuments_comparedocuments_component__["a" /* ComparedocumentsComponent */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_forms__["a" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_10__ng_bootstrap_ng_bootstrap__["c" /* NgbModule */].forRoot(),
                __WEBPACK_IMPORTED_MODULE_21__app_routing_module__["a" /* AppRoutingModule */],
                __WEBPACK_IMPORTED_MODULE_9__angular_common_http__["b" /* HttpClientModule */]
            ],
            schemas: [__WEBPACK_IMPORTED_MODULE_1__angular_core__["j" /* CUSTOM_ELEMENTS_SCHEMA */]],
            providers: [__WEBPACK_IMPORTED_MODULE_7__services_assignment_service__["a" /* AssignmentService */], __WEBPACK_IMPORTED_MODULE_12__services_report_service__["a" /* ReportService */], __WEBPACK_IMPORTED_MODULE_13__services_user_service__["a" /* UserService */], __WEBPACK_IMPORTED_MODULE_14__services_submission_service__["a" /* SubmissionService */], __WEBPACK_IMPORTED_MODULE_18__services_alert_service__["a" /* AlertService */], __WEBPACK_IMPORTED_MODULE_23__services_analytics_service__["a" /* AnalyticsService */],
                __WEBPACK_IMPORTED_MODULE_22__auth_guard__["a" /* AuthGuardGrader */], __WEBPACK_IMPORTED_MODULE_22__auth_guard__["b" /* AuthGuardStudent */]],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_3__app_component__["a" /* AppComponent */]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "../../../../../src/app/auth.guard.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AuthGuardGrader; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return AuthGuardStudent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__services_user_service__ = __webpack_require__("../../../../../src/app/services/user.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var AuthGuardGrader = (function () {
    function AuthGuardGrader(router, userService) {
        this.router = router;
        this.userService = userService;
    }
    AuthGuardGrader.prototype.canActivate = function (route, state) {
        if (JSON.parse(localStorage.getItem('currentUser'))["grader"]) {
            // logged in so return true
            return true;
        }
        // not logged in so redirect to login page with the return url
        this.router.navigate(['login'], { queryParams: { returnUrl: state.url } });
        return false;
    };
    AuthGuardGrader = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_router__["d" /* Router */], __WEBPACK_IMPORTED_MODULE_2__services_user_service__["a" /* UserService */]])
    ], AuthGuardGrader);
    return AuthGuardGrader;
}());

var AuthGuardStudent = (function () {
    function AuthGuardStudent(router) {
        this.router = router;
    }
    AuthGuardStudent.prototype.canActivate = function (route, state) {
        if (localStorage.getItem('currentUser')) {
            // logged in so return true
            return true;
        }
        // not logged in so redirect to login page with the return url
        this.router.navigate(['login'], { queryParams: { returnUrl: state.url } });
        return false;
    };
    AuthGuardStudent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_router__["d" /* Router */]])
    ], AuthGuardStudent);
    return AuthGuardStudent;
}());



/***/ }),

/***/ "../../../../../src/app/components/assignmentlist/assignmentlist.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".selected {\n  background-color: #CFD8DC !important;\n  color: white; }\n\n* {\n  color: black; }\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/components/assignmentlist/assignmentlist.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"card mb-3\">\n  <div class=\"card-header\">\n    <i class=\"fa fa-table\"></i> My Assignments</div>\n  <div class=\"card-body\">\n    <div class=\"table-responsive\">\n      <table class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">\n        <thead>\n        <tr>\n          <th>Name</th>\n          <th>Course</th>\n          <th>Is Analyzed</th>\n          <th>Analyze</th>\n        </tr>\n        </thead>\n        <tbody>\n        <tr *ngFor=\"let assignment of assignments\">\n          <td><a routerLink=\"/assignment/{{assignment.id}}/submissions\" style=\"color: dodgerblue\">{{assignment.name}}</a></td>\n            <td>{{assignment.course}}</td>\n            <td>{{assignment.analyzed}}</td>\n            <td><a class=\"btn btn-danger white-text\" *ngIf=\"!assignment.analyzed\" (click)=\"analyze(assignment.id)\">Analyze!</a></td>\n        </tr>\n        </tbody>\n        <tfoot><a class=\"btn btn-primary white-text align-items-center\" style=\"margin: 0.5em\" routerLink=\"/assignments/new\">Add New</a></tfoot>\n      </table>\n    </div>\n  </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/components/assignmentlist/assignmentlist.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AssignmentListComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_assignment_service__ = __webpack_require__("../../../../../src/app/services/assignment.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common__ = __webpack_require__("../../../common/esm5/common.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



/**
 * The Component that creates the Assignment List page
 */
var AssignmentListComponent = (function () {
    function AssignmentListComponent(assignmentService, location) {
        this.assignmentService = assignmentService;
        this.location = location;
    }
    /**
     * On page load
     */
    AssignmentListComponent.prototype.ngOnInit = function () {
        this.getAssignments();
    };
    /**
     * Get assignments
     */
    AssignmentListComponent.prototype.getAssignments = function () {
        var _this = this;
        this.assignmentService.getAssignments().subscribe(function (assignments) {
            console.log(assignments);
            _this.assignments = assignments;
        });
    };
    /**
     * Analyze assignment with given id
     * @param {string} id assignment id
     */
    AssignmentListComponent.prototype.analyze = function (id) {
        console.log(id);
        this.assignmentService.analyze(id).subscribe(function (res) {
            console.log(res);
            location.reload();
        });
    };
    AssignmentListComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
            selector: 'app-assignment-list',
            template: __webpack_require__("../../../../../src/app/components/assignmentlist/assignmentlist.component.html"),
            styles: [__webpack_require__("../../../../../src/app/components/assignmentlist/assignmentlist.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__services_assignment_service__["a" /* AssignmentService */],
            __WEBPACK_IMPORTED_MODULE_2__angular_common__["f" /* Location */]])
    ], AssignmentListComponent);
    return AssignmentListComponent;
}());



/***/ }),

/***/ "../../../../../src/app/components/assignmentnew/assignmentnew.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/components/assignmentnew/assignmentnew.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"card mx-auto mt-5\">\n  <div class=\"card-header\">Upload Submission</div>\n  <div class=\"card-body\">\n    <form>\n      <div class=\"form-group\">\n        <label for=\"InputName\">Name</label>\n        <input [(ngModel)]=\"name\" class=\"form-control\" name=\"name\" id=\"InputName\" type=\"text\" aria-describedby=\"nameHelp\" placeholder=\"name\">\n      </div>\n      <div class=\"form-group\">\n        <label for=\"InputCourse\">Course</label>\n        <input [(ngModel)]=\"course\" class=\"form-control\" name=\"course\" id=\"InputCourse\" type=\"text\" placeholder=\"Course\">\n      </div>\n      <a class=\"btn btn-primary btn-block white-text\" (click)=\"save()\">Save</a>\n    </form>\n  </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/components/assignmentnew/assignmentnew.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AssignmentNewComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common__ = __webpack_require__("../../../common/esm5/common.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_assignment_service__ = __webpack_require__("../../../../../src/app/services/assignment.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




/**
 * The Component that creates the new Assignment page
 */
var AssignmentNewComponent = (function () {
    function AssignmentNewComponent(router, assignmentService, location) {
        this.router = router;
        this.assignmentService = assignmentService;
        this.location = location;
    }
    /**
     * On page load
     */
    AssignmentNewComponent.prototype.ngOnInit = function () { };
    /**
     * Save the form
     */
    AssignmentNewComponent.prototype.save = function () {
        var _this = this;
        var data = { "name": this.name, "course": this.course, "isAnalyzed": false };
        this.assignmentService.createAssignment(data)
            .subscribe(function () { return _this.goBack(); });
    };
    /**
     *   Go back to previous page
     */
    AssignmentNewComponent.prototype.goBack = function () {
        this.location.back();
    };
    AssignmentNewComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
            selector: 'app-assignment-new',
            template: __webpack_require__("../../../../../src/app/components/assignmentnew/assignmentnew.component.html"),
            styles: [__webpack_require__("../../../../../src/app/components/assignmentnew/assignmentnew.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_router__["d" /* Router */],
            __WEBPACK_IMPORTED_MODULE_3__services_assignment_service__["a" /* AssignmentService */],
            __WEBPACK_IMPORTED_MODULE_2__angular_common__["f" /* Location */]])
    ], AssignmentNewComponent);
    return AssignmentNewComponent;
}());



/***/ }),

/***/ "../../../../../src/app/components/comparedocuments/comparedocuments.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".doc-compare-content {\n  background-color: #3c3c3c;\n  color: #f3f5f7 !important;\n  padding: 1rem;\n  margin: 0.2rem;\n  font-size: smaller;\n  font-family: \"Consolas\", \"Courier\", monospace; }\n  .doc-compare-content span .highlight-similar {\n    background-color: red !important; }\n  .doc-compare-content h4 {\n    font-family: sans-serif !important;\n    text-transform: capitalize !important; }\n\n.highlight {\n  color: white;\n  background-color: black; }\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/components/comparedocuments/comparedocuments.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"modal-header\">\n  <h4 style=\"text-transform: capitalize;\">{{model}} Model</h4>\n  <button type=\"button\" class=\"close\" aria-label=\"Close\" (click)=\"activeModal.dismiss('Cross click')\">\n    <span aria-hidden=\"true\">&times;</span>\n  </button>\n</div>\n<div class=\"container-fluid\">\n  <div class=\"row \">\n    <div class=\"col doc-compare-content\">\n      <h4>{{studentname1}}'s Submission</h4>\n      <div [innerHTML]=\"doc1\"></div>\n    </div>\n    <div class=\"col doc-compare-content\">\n      <h4>{{studentname2}}'s Submission</h4>\n      <div [innerHTML]=\"doc2\"></div>\n    </div>\n  </div>\n</div>\n<div class=\"modal-footer\">\n  <button type=\"button\" class=\"btn btn-outline-dark\" (click)=\"activeModal.close('Close click')\">Close</button>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/components/comparedocuments/comparedocuments.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ComparedocumentsComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__ng_bootstrap_ng_bootstrap__ = __webpack_require__("../../../../@ng-bootstrap/ng-bootstrap/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__services_submission_service__ = __webpack_require__("../../../../../src/app/services/submission.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_report_service__ = __webpack_require__("../../../../../src/app/services/report.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__services_user_service__ = __webpack_require__("../../../../../src/app/services/user.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





/**
 * Compponent that creates the compare documents
 */
var ComparedocumentsComponent = (function () {
    function ComparedocumentsComponent(activeModal, submissionService, reportService, userService) {
        this.activeModal = activeModal;
        this.submissionService = submissionService;
        this.reportService = reportService;
        this.userService = userService;
        this.openingTag = "<span class='highlight-similar'>";
        this.closingTag = "</span>";
        this.tagLength = this.openingTag.length + this.closingTag.length;
    }
    /**
     * On page load
     */
    ComparedocumentsComponent.prototype.ngOnInit = function () {
        this.getStudentNames();
        this.getDocuments();
        switch (this.model) {
            case "structure":
                this.modelId = 1;
                break;
            case "loop":
                this.modelId = 2;
                break;
            case "method":
                this.modelId = 3;
                break;
            case "winnowing":
                this.modelId = 5;
                break;
        }
    };
    /**
     * Get both student names
     */
    ComparedocumentsComponent.prototype.getStudentNames = function () {
        var _this = this;
        this.userService.getUserById(this.student1).subscribe(function (student) { return _this.studentname1 = student.name; });
        this.userService.getUserById(this.student2).subscribe(function (student) { return _this.studentname2 = student.name; });
    };
    /**
     * Get both the documents
     */
    ComparedocumentsComponent.prototype.getDocuments = function () {
        var _this = this;
        this.submissionService.getSubmission(this.refFileId).subscribe(function (submission) {
            _this.doc1 = submission.filecontent;
            _this.submissionService.getSubmission(_this.similarFileId).subscribe(function (submission) {
                _this.doc2 = submission.filecontent;
                _this.highlightDocuments();
            });
        });
    };
    /**
     * Highlight lines in the code
     */
    ComparedocumentsComponent.prototype.highlightDocuments = function () {
        var _this = this;
        this.reportService.getReportByIds(this.refFileId, this.similarFileId).subscribe(function (report) {
            var lines = report.models.filter(function (m) { return m.model === _this.modelId; })[0].lines;
            _this.filterLines(lines, function (l) { return l.refOffset; }, function (l) { return l.refLength; });
            _this.filterLines(lines, function (l) { return l.similarOffset; }, function (l) { return l.similarLength; });
            _this.doc1 = _this.createSpanElements(lines, _this.doc1, function (l) { return l.refOffset; }, function (l) { return l.refLength; });
            _this.doc2 = _this.createSpanElements(lines, _this.doc2, function (l) { return l.similarOffset; }, function (l) { return l.similarLength; });
            _this.doc1 = _this.doc1.replace(/\n/g, "<br>");
            _this.doc2 = _this.doc2.replace(/\n/g, "<br>");
        });
    };
    /**
     *  Filter the lines in report, so that they don't overlap
     * @param {ReportLine[]} lines
     * @param {(_) => any} fnOffset function to access the offset field
     * @param {(_) => any} fnLength function to access the length field
     */
    ComparedocumentsComponent.prototype.filterLines = function (lines, fnOffset, fnLength) {
        if (fnOffset === void 0) { fnOffset = function (_) { return _; }; }
        if (fnLength === void 0) { fnLength = function (_) { return _; }; }
        var sortLines = lines.sort(function (a, b) {
            var offseta = fnOffset(a);
            var offsetb = fnOffset(b);
            if (offseta == offsetb && fnLength(a) == fnLength(b))
                return 0;
            if (offseta == offsetb && fnLength(a) < fnLength(b))
                return 1;
            if (offseta == offsetb && fnLength(a) > fnLength(b))
                return -1;
            if (offseta < offsetb)
                return -1;
            if (offseta > offsetb)
                return 1;
        });
        this.removeDuplicateLines(sortLines, fnOffset, fnLength);
    };
    /**
     * Remove any duplicate offsets
     * @param {ReportLine[]} arr Report Lines
     * @param {(_) => any} fnOffset function to access the offset field
     * @param {(_) => any} fnLength function to access the length field
     * @returns {ReportLine[] | undefined} Report Lines with duplicates removed
     */
    ComparedocumentsComponent.prototype.removeDuplicateLines = function (arr, fnOffset, fnLength) {
        if (arr === void 0) { arr = []; }
        if (fnOffset === void 0) { fnOffset = function (_) { return _; }; }
        if (fnLength === void 0) { fnLength = function (_) { return _; }; }
        var set = new Set();
        var len = arr.length;
        for (var i = 0; i < len; i++) {
            var offset = fnOffset(arr[i]);
            var length_1 = fnLength(arr[i]);
            if (set.has(offset)) {
                arr.splice(i, 1);
                i--;
                len--;
            }
            else {
                set.add(offset);
            }
        }
        var offsets = arr.map(function (l) { return fnOffset(l) + fnLength(l); });
        for (var i = 0; i < arr.length; i++) {
            if (arr[i].refOffset in offsets) {
                arr.splice(i, 1);
                i--;
                len--;
            }
        }
    };
    /**
     * Create span element
     * @param {ReportLine[]} lines Report Lines
     * @param {string} doc document
     * @param {(_) => any} fnOffset function to access the offset field
     * @param {(_) => any} fnLength function to access the length field
     * @returns {string} new document
     */
    ComparedocumentsComponent.prototype.createSpanElements = function (lines, doc, fnOffset, fnLength) {
        if (fnOffset === void 0) { fnOffset = function (_) { return _; }; }
        if (fnLength === void 0) { fnLength = function (_) { return _; }; }
        var docOffset = 0;
        for (var _i = 0, lines_1 = lines; _i < lines_1.length; _i++) {
            var line = lines_1[_i];
            var substring = doc.substr(docOffset + fnOffset(line), fnLength(line));
            console.log(substring.search("s?pan?"));
            if (substring.indexOf(this.openingTag) === -1 && substring.indexOf(this.closingTag) === -1 && substring.search("s?pan?>?") === -1) {
                doc = this.addTag(doc, docOffset, fnOffset(line), fnLength(line));
                docOffset += this.tagLength;
            }
        }
        return doc;
    };
    /**
     * Add tag
     * @param doc
     * @param docOffset
     * @param offset
     * @param length
     * @returns {any}
     */
    ComparedocumentsComponent.prototype.addTag = function (doc, docOffset, offset, length) {
        doc = this.insertTag(doc, this.openingTag, docOffset + offset);
        docOffset += this.openingTag.length;
        doc = this.insertTag(doc, this.closingTag, docOffset + offset + length);
        return doc;
    };
    /**
     * Insert tag
     * @param main_string
     * @param ins_string
     * @param pos
     * @returns {any}
     */
    ComparedocumentsComponent.prototype.insertTag = function (main_string, ins_string, pos) {
        if (typeof (pos) === "undefined") {
            pos = 0;
        }
        if (typeof (ins_string) === "undefined") {
            ins_string = '';
        }
        return main_string.slice(0, pos) + ins_string + main_string.slice(pos);
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["F" /* Input */])(),
        __metadata("design:type", Object)
    ], ComparedocumentsComponent.prototype, "model", void 0);
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["F" /* Input */])(),
        __metadata("design:type", Object)
    ], ComparedocumentsComponent.prototype, "refFileId", void 0);
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["F" /* Input */])(),
        __metadata("design:type", Object)
    ], ComparedocumentsComponent.prototype, "similarFileId", void 0);
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["F" /* Input */])(),
        __metadata("design:type", Object)
    ], ComparedocumentsComponent.prototype, "student1", void 0);
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["F" /* Input */])(),
        __metadata("design:type", Object)
    ], ComparedocumentsComponent.prototype, "student2", void 0);
    ComparedocumentsComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
            selector: 'app-comparedocuments',
            template: __webpack_require__("../../../../../src/app/components/comparedocuments/comparedocuments.component.html"),
            styles: [__webpack_require__("../../../../../src/app/components/comparedocuments/comparedocuments.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__ng_bootstrap_ng_bootstrap__["a" /* NgbActiveModal */],
            __WEBPACK_IMPORTED_MODULE_2__services_submission_service__["a" /* SubmissionService */],
            __WEBPACK_IMPORTED_MODULE_3__services_report_service__["a" /* ReportService */],
            __WEBPACK_IMPORTED_MODULE_4__services_user_service__["a" /* UserService */]])
    ], ComparedocumentsComponent);
    return ComparedocumentsComponent;
}());



/***/ }),

/***/ "../../../../../src/app/components/home/home.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "h1, h2, h3, h4, h5, h6 {\n  font-family: 'Cabin', 'Helvetica Neue', Helvetica, Arial, sans-serif;\n  font-weight: 700;\n  margin: 0 0 35px;\n  letter-spacing: 1px;\n  text-transform: uppercase; }\n\np {\n  font-size: 16px;\n  line-height: 1.5;\n  margin: 0 0 25px; }\n\n@media (min-width: 768px) {\n  p {\n    font-size: 18px;\n    line-height: 1.6;\n    margin: 0 0 35px; } }\na {\n  transition: all 0.2s ease-in-out;\n  color: #42DCA3; }\n  a:focus, a:hover {\n    text-decoration: none;\n    color: #1d9b6c; }\n\n.masthead {\n  display: table;\n  width: 100%;\n  height: auto;\n  padding: 200px 0;\n  text-align: center;\n  color: white;\n  background: url(" + __webpack_require__("../../../../../src/assets/images/home-top-bg.jpg") + ") no-repeat bottom center scroll;\n  background-color: black;\n  background-size: cover; }\n  .masthead .intro-body {\n    display: table-cell;\n    vertical-align: middle; }\n    .masthead .intro-body .brand-heading {\n      font-size: 50px; }\n    .masthead .intro-body .intro-text {\n      font-size: 18px; }\n\n@media (min-width: 768px) {\n  .masthead {\n    height: 100%;\n    padding: 0; }\n    .masthead .intro-body .brand-heading {\n      font-size: 100px; }\n    .masthead .intro-body .intro-text {\n      font-size: 22px; } }\n.btn-circle {\n  font-size: 26px;\n  width: 55px;\n  height: 55px;\n  margin-top: 15px;\n  line-height: 45px;\n  transition: background 0.3s ease-in-out;\n  color: white;\n  border: 2px solid white;\n  border-radius: 100% !important;\n  background: transparent; }\n  .btn-circle:focus, .btn-circle:hover {\n    color: white;\n    outline: none;\n    background: rgba(255, 255, 255, 0.1); }\n\n.content-section {\n  padding-top: 150px;\n  padding-bottom: 150px; }\n\n.download-section {\n  color: white;\n  background: url(" + __webpack_require__("../../../../../src/assets/images/home-login-bg.jpg") + ") no-repeat center center scroll;\n  background-color: black;\n  background-size: cover; }\n\n#map {\n  width: 100%;\n  height: 300px; }\n\n@media (min-width: 992px) {\n  .content-section {\n    padding-top: 200px;\n    padding-bottom: 200px; }\n\n  #map {\n    height: 350px; } }\n.btn {\n  font-family: 'Cabin', 'Helvetica Neue', Helvetica, Arial, sans-serif;\n  font-weight: 400;\n  transition: all 0.3s ease-in-out;\n  text-transform: uppercase;\n  border-radius: 0; }\n\n.btn-default {\n  color: #42DCA3;\n  border: 1px solid #42DCA3;\n  background-color: transparent; }\n  .btn-default:focus, .btn-default:hover {\n    color: black;\n    border: 1px solid #42DCA3;\n    outline: none;\n    background-color: #42DCA3; }\n\nul.banner-social-buttons {\n  margin-top: 0; }\n\n@media (max-width: 1199px) {\n  ul.banner-social-buttons {\n    margin-top: 15px; } }\n@media (max-width: 767px) {\n  ul.banner-social-buttons li {\n    display: block;\n    margin-bottom: 20px;\n    padding: 0; }\n    ul.banner-social-buttons li:last-child {\n      margin-bottom: 0; } }\nfooter {\n  padding: 50px 0; }\n  footer p {\n    font-size: 14px;\n    margin: 0; }\n\n::-moz-selection, ::-moz-selection {\n  background: #fcfcfc;\n  background: rgba(255, 255, 255, 0.2);\n  text-shadow: none; }\n\n::-moz-selection, ::selection {\n  background: #fcfcfc;\n  background: rgba(255, 255, 255, 0.2);\n  text-shadow: none; }\n\nimg::-moz-selection, img::-moz-selection {\n  background: transparent; }\n\nimg::selection, img::-moz-selection {\n  background: transparent; }\n\nbody {\n  -webkit-tap-highlight-color: rgba(255, 255, 255, 0.2);\n  color: white !important;\n  background-color: black !important; }\n\n#about, #contact {\n  background-color: black;\n  color: white; }\n\nfooter {\n  color: white !important; }\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/components/home/home.component.html":
/***/ (function(module, exports) {

module.exports = "<!-- Intro Header -->\n<header class=\"masthead\">\n  <div class=\"intro-body\">\n    <div class=\"container\">\n      <div class=\"row\">\n        <div class=\"col-lg-8 mx-auto\">\n          <h1 class=\"brand-heading\">Dupe Detective</h1>\n          <p class=\"intro-text\">If there is plagiarism, we'll get it.\n            <!--<br>Created by team 27.-->\n          </p>\n        </div>\n      </div>\n    </div>\n  </div>\n</header>\n\n<!-- About Section -->\n<section id=\"about\" class=\"content-section text-center\">\n  <div class=\"container\">\n    <div class=\"row\">\n      <div class=\"col-lg-8 mx-auto\">\n        <h2>About Dupe Detective</h2>\n        <p>We use state of the art algorithms to go through assignments and detect plagiarism.</p>\n      </div>\n    </div>\n  </div>\n</section>\n\n<!-- Download Section -->\n<section id=\"download\" class=\"download-section content-section text-center\">\n  <div class=\"container\">\n    <div class=\"col-lg-8 mx-auto\">\n      <h2>Start using Dupe Detective</h2>\n      <div class=\"row align-content-between\">\n      <div class=\"col-sm-6\">\n      <!--<p>Students Start here</p>-->\n      <a routerLink=\"/register\" class=\"btn btn-default btn-lg\">Student</a>\n      </div>\n      <div class=\"col-sm-6\">\n        <!--<p>Students Start here</p>-->\n        <a routerLink=\"/register\" class=\"btn btn-default btn-lg\">Grader</a>\n      </div>\n      </div>\n    </div>\n  </div>\n</section>\n\n<!-- Contact Section -->\n<section id=\"contact\" class=\"content-section text-center\">\n  <div class=\"container\">\n    <div class=\"row\">\n      <div class=\"col-lg-8 mx-auto\">\n        <h2>Notice any Issues?</h2>\n        <p>Feel free to drop us a line on\n          <a href=\"https://github.ccs.neu.edu/cs5500/team-27\" target=\"_blank\">Github</a>\n           to give some feedback about this project!</p>\n        <ul class=\"list-inline banner-social-buttons\">\n          <li class=\"list-inline-item\">\n            <a href=\"https://www.twitter.com/\" target=\"_blank\" class=\"btn btn-default btn-lg\">\n              <i class=\"fa fa-twitter fa-fw\"></i>\n              <span class=\"network-name\">Twitter</span>\n            </a>\n          </li>\n          <li class=\"list-inline-item\">\n            <a href=\"https://github.ccs.neu.edu/cs5500/team-27\" target=\"_blank\" class=\"btn btn-default btn-lg\">\n              <i class=\"fa fa-github fa-fw\"></i>\n              <span class=\"network-name\">Github</span>\n            </a>\n          </li>\n        </ul>\n      </div>\n    </div>\n  </div>\n</section>\n\n<!-- Footer -->\n<footer>\n  <div class=\"container text-center\">\n    <p>Copyright &copy; Dupe Detective 2017</p>\n    <p>Themes from StartBootstrap.com</p>\n  </div>\n</footer>\n\n<!-- TODO: replace this with angular easing or fix with jquery -->\n<!-- Plugin JavaScript -->\n<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js\"></script>\n\n<script src=\"grayscale.min.js\"></script>\n"

/***/ }),

/***/ "../../../../../src/app/components/home/home.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HomeComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

/**
 * Home component
 */
var HomeComponent = (function () {
    function HomeComponent() {
        this.title = 'Dupe Detective';
    }
    HomeComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
            template: __webpack_require__("../../../../../src/app/components/home/home.component.html"),
            styles: [__webpack_require__("../../../../../src/app/components/home/home.component.css")]
        })
    ], HomeComponent);
    return HomeComponent;
}());



/***/ }),

/***/ "../../../../../src/app/components/login/login.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/components/login/login.component.html":
/***/ (function(module, exports) {

module.exports = "<br>\n<div class=\"container\">\n<div class=\"card card-login mx-auto mt-5\" style=\"color: #777;\">\n  <div class=\"card-header\">Login</div>\n  <div class=\"card-body\">\n    <div *ngIf=\"message\" [ngClass]=\"{ 'alert': message, 'alert-success': message.type === 'success', 'alert-danger': message.type === 'error' }\">{{message.text}}</div>\n    <form>\n      <div class=\"form-group\">\n        <label for=\"InputUsername\">Username</label>\n        <input [(ngModel)]=\"username\" class=\"form-control\" name=\"username\" id=\"InputUsername\" type=\"text\" aria-describedby=\"usernameHelp\" placeholder=\"Username\">\n      </div>\n      <div class=\"form-group\">\n        <label for=\"InputPassword\">Password</label>\n        <input [(ngModel)]=\"password\" class=\"form-control\" name=\"password\" id=\"InputPassword\" type=\"password\" placeholder=\"Password\">\n      </div>\n      <div class=\"form-group\">\n        <div class=\"form-check\">\n          <label class=\"form-check-label\">\n            <input class=\"form-check-input\" type=\"checkbox\"> Remember Password</label>\n        </div>\n      </div>\n      <a class=\"btn btn-primary btn-block white-text\" (click)=\"login()\" autofocus>Login</a>\n    </form>\n    <div class=\"text-center\">\n      <a class=\"d-block small mt-3\" routerLink=\"/register\">Register an Account</a>\n    </div>\n</div>\n</div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/components/login/login.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LoginComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_user_service__ = __webpack_require__("../../../../../src/app/services/user.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



/**
 * Handle user login
 */
var LoginComponent = (function () {
    function LoginComponent(userService, router) {
        this.userService = userService;
        this.router = router;
    }
    /**
     * On page load
     */
    LoginComponent.prototype.ngOnInit = function () { };
    /**
     * Login the user
     */
    LoginComponent.prototype.login = function () {
        var _this = this;
        this.userService.getUser(this.username, this.password).subscribe(function (user) {
            if (user !== undefined && JSON.stringify(user) !== "undefined") {
                localStorage.setItem("currentUser", JSON.stringify(user));
                if (user && user["grader"]) {
                    _this.router.navigate(['/assignments']);
                }
                else if (user && !user["grader"]) {
                    _this.router.navigate(['/submissions/new']);
                }
            }
        });
    };
    LoginComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
            selector: 'app-login',
            template: __webpack_require__("../../../../../src/app/components/login/login.component.html"),
            styles: [__webpack_require__("../../../../../src/app/components/login/login.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__services_user_service__["a" /* UserService */], __WEBPACK_IMPORTED_MODULE_2__angular_router__["d" /* Router */]])
    ], LoginComponent);
    return LoginComponent;
}());



/***/ }),

/***/ "../../../../../src/app/components/navbar/navbar.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "#homeNav {\n  font-family: 'Cabin', 'Helvetica Neue', Helvetica, Arial, sans-serif;\n  margin-bottom: 0;\n  text-transform: uppercase;\n  border-bottom: 1px solid rgba(255, 255, 255, 0.3);\n  background-color: black; }\n  #homeNav .navbar-toggler {\n    font-size: 14px;\n    padding: 11px;\n    color: white;\n    border: 1px solid white; }\n  #homeNav .navbar-brand {\n    font-weight: 700; }\n  #homeNav a {\n    color: white; }\n  #homeNav .navbar-nav .nav-item {\n    transition: background 0.3s ease-in-out; }\n    #homeNav .navbar-nav .nav-item:hover {\n      color: fade(#ffffff, 80%);\n      outline: none;\n      background-color: transparent; }\n    #homeNav .navbar-nav .nav-item:active, #homeNav .navbar-nav .nav-item:focus {\n      outline: none;\n      background-color: transparent; }\n  #homeNav .dropdown-item {\n    color: black; }\n\n@media (min-width: 992px) {\n  #homeNav {\n    padding-top: 20px;\n    padding-bottom: 20px;\n    transition: background 0.3s ease-in-out, padding-top 0.3s ease-in-out, padding-bottom 0.3s;\n    letter-spacing: 1px;\n    border-bottom: none;\n    background: transparent; }\n    #homeNav.navbar-shrink {\n      padding-top: 10px;\n      padding-bottom: 10px;\n      border-bottom: 1px solid rgba(255, 255, 255, 0.3);\n      background: black; }\n    #homeNav .nav-link.active {\n      outline: none;\n      background-color: rgba(255, 255, 255, 0.3); }\n      #homeNav .nav-link.active:hover {\n        color: white; }\n    #homeNav .dropdown-item {\n      color: black; } }\n#mainNav .navbar-collapse {\n  overflow: auto;\n  max-height: 75vh; }\n\n#mainNav .navbar-collapse .navbar-nav .nav-item .nav-link {\n  cursor: pointer; }\n\n#mainNav .navbar-collapse .navbar-sidenav .nav-link-collapse:after {\n  float: right;\n  content: '\\F107';\n  font-family: 'FontAwesome'; }\n\n#mainNav .navbar-collapse .navbar-sidenav .nav-link-collapse.collapsed:after {\n  content: '\\F105'; }\n\n#mainNav .navbar-collapse .navbar-sidenav .sidenav-second-level,\n#mainNav .navbar-collapse .navbar-sidenav .sidenav-third-level {\n  padding-left: 0; }\n\n#mainNav .navbar-collapse .navbar-sidenav .sidenav-second-level > li > a,\n#mainNav .navbar-collapse .navbar-sidenav .sidenav-third-level > li > a {\n  display: block;\n  padding: 0.5em 0; }\n\n#mainNav .navbar-collapse .navbar-sidenav .sidenav-second-level > li > a:focus, #mainNav .navbar-collapse .navbar-sidenav .sidenav-second-level > li > a:hover,\n#mainNav .navbar-collapse .navbar-sidenav .sidenav-third-level > li > a:focus,\n#mainNav .navbar-collapse .navbar-sidenav .sidenav-third-level > li > a:hover {\n  text-decoration: none; }\n\n#mainNav .navbar-collapse .navbar-sidenav .sidenav-second-level > li > a {\n  padding-left: 1em; }\n\n#mainNav .navbar-collapse .navbar-sidenav .sidenav-third-level > li > a {\n  padding-left: 2em; }\n\n#mainNav .navbar-collapse .sidenav-toggler {\n  display: none; }\n\n#mainNav .navbar-collapse .navbar-nav > .nav-item.dropdown > .nav-link {\n  position: relative;\n  min-width: 45px; }\n\n#mainNav .navbar-collapse .navbar-nav > .nav-item.dropdown > .nav-link:after {\n  float: right;\n  width: auto;\n  content: '\\F105';\n  border: none;\n  font-family: 'FontAwesome'; }\n\n#mainNav .navbar-collapse .navbar-nav > .nav-item.dropdown > .nav-link .indicator {\n  position: absolute;\n  top: 5px;\n  left: 21px;\n  font-size: 10px; }\n\n#mainNav .navbar-collapse .navbar-nav > .nav-item.dropdown.show > .nav-link:after {\n  content: '\\F107'; }\n\n#mainNav .navbar-collapse .navbar-nav > .nav-item.dropdown .dropdown-menu > .dropdown-item > .dropdown-message {\n  overflow: hidden;\n  max-width: none;\n  text-overflow: ellipsis; }\n\n@media (min-width: 992px) {\n  #mainNav .navbar-brand {\n    width: 250px; }\n\n  #mainNav .navbar-collapse {\n    overflow: visible;\n    max-height: none; }\n\n  #mainNav .navbar-collapse .navbar-sidenav {\n    position: absolute;\n    top: 0;\n    left: 0;\n    overflow-x: hidden;\n    overflow-y: auto;\n    -ms-flex-direction: column;\n    -webkit-box-orient: vertical;\n    -webkit-box-direction: normal;\n            flex-direction: column;\n    margin-top: 56px; }\n\n  #mainNav .navbar-collapse .navbar-sidenav > .nav-item {\n    width: 250px;\n    padding: 0; }\n\n  #mainNav .navbar-collapse .navbar-sidenav > .nav-item > .nav-link {\n    padding: 1em; }\n\n  #mainNav .navbar-collapse .navbar-sidenav > .nav-item .sidenav-second-level,\n  #mainNav .navbar-collapse .navbar-sidenav > .nav-item .sidenav-third-level {\n    padding-left: 0;\n    list-style: none; }\n\n  #mainNav .navbar-collapse .navbar-sidenav > .nav-item .sidenav-second-level > li,\n  #mainNav .navbar-collapse .navbar-sidenav > .nav-item .sidenav-third-level > li {\n    width: 250px; }\n\n  #mainNav .navbar-collapse .navbar-sidenav > .nav-item .sidenav-second-level > li > a,\n  #mainNav .navbar-collapse .navbar-sidenav > .nav-item .sidenav-third-level > li > a {\n    padding: 1em; }\n\n  #mainNav .navbar-collapse .navbar-sidenav > .nav-item .sidenav-second-level > li > a {\n    padding-left: 2.75em; }\n\n  #mainNav .navbar-collapse .navbar-sidenav > .nav-item .sidenav-third-level > li > a {\n    padding-left: 3.75em; }\n\n  #mainNav .navbar-collapse .navbar-nav > .nav-item.dropdown > .nav-link {\n    min-width: 0; }\n\n  #mainNav .navbar-collapse .navbar-nav > .nav-item.dropdown > .nav-link:after {\n    width: 24px;\n    text-align: center; }\n\n  #mainNav .navbar-collapse .navbar-nav > .nav-item.dropdown .dropdown-menu > .dropdown-item > .dropdown-message {\n    max-width: 300px; } }\n#mainNav.fixed-top .sidenav-toggler {\n  display: none; }\n\n@media (min-width: 992px) {\n  #mainNav.fixed-top .navbar-sidenav {\n    height: calc(100vh - 112px); }\n\n  #mainNav.fixed-top .sidenav-toggler {\n    position: absolute;\n    top: 0;\n    left: 0;\n    display: -webkit-box;\n    display: -ms-flexbox;\n    display: flex;\n    overflow-x: hidden;\n    overflow-y: auto;\n    -ms-flex-direction: column;\n    -webkit-box-orient: vertical;\n    -webkit-box-direction: normal;\n            flex-direction: column;\n    margin-top: calc(100vh - 56px); }\n\n  #mainNav.fixed-top .sidenav-toggler > .nav-item {\n    width: 250px;\n    padding: 0; }\n\n  #mainNav.fixed-top .sidenav-toggler > .nav-item > .nav-link {\n    padding: 1em; } }\n#mainNav.fixed-top.navbar-dark .sidenav-toggler {\n  background-color: #212529; }\n\n#mainNav.fixed-top.navbar-dark .sidenav-toggler a i {\n  color: #adb5bd; }\n\n#mainNav.fixed-top.navbar-light .sidenav-toggler {\n  background-color: #dee2e6; }\n\n#mainNav.fixed-top.navbar-light .sidenav-toggler a i {\n  color: rgba(0, 0, 0, 0.5); }\n\nbody.sidenav-toggled #mainNav.fixed-top .sidenav-toggler {\n  overflow-x: hidden;\n  width: 55px; }\n\nbody.sidenav-toggled #mainNav.fixed-top .sidenav-toggler .nav-item,\nbody.sidenav-toggled #mainNav.fixed-top .sidenav-toggler .nav-link {\n  width: 55px !important; }\n\nbody.sidenav-toggled #mainNav.fixed-top #sidenavToggler i {\n  -webkit-transform: scaleX(-1);\n  transform: scaleX(-1);\n  -webkit-filter: FlipH;\n          filter: FlipH;\n  -ms-filter: 'FlipH'; }\n\n#mainNav.static-top .sidenav-toggler {\n  display: none; }\n\n@media (min-width: 992px) {\n  #mainNav.static-top .sidenav-toggler {\n    display: -webkit-box;\n    display: -ms-flexbox;\n    display: flex; } }\nbody.sidenav-toggled #mainNav.static-top #sidenavToggler i {\n  -webkit-transform: scaleX(-1);\n  transform: scaleX(-1);\n  -webkit-filter: FlipH;\n          filter: FlipH;\n  -ms-filter: 'FlipH'; }\n\n.content-wrapper {\n  overflow-x: hidden;\n  background: white; }\n\n@media (min-width: 992px) {\n  .content-wrapper {\n    margin-left: 250px; } }\n#sidenavToggler i {\n  font-weight: 800; }\n\n.navbar-sidenav-tooltip.show {\n  display: none; }\n\n@media (min-width: 992px) {\n  body.sidenav-toggled .content-wrapper {\n    margin-left: 55px; } }\nbody.sidenav-toggled .navbar-sidenav {\n  overflow-x: hidden;\n  width: 55px; }\n\nbody.sidenav-toggled .navbar-sidenav .nav-link-text {\n  display: none; }\n\nbody.sidenav-toggled .navbar-sidenav .nav-item,\nbody.sidenav-toggled .navbar-sidenav .nav-link {\n  width: 55px !important; }\n\nbody.sidenav-toggled .navbar-sidenav .nav-item:after,\nbody.sidenav-toggled .navbar-sidenav .nav-link:after {\n  display: none; }\n\nbody.sidenav-toggled .navbar-sidenav-tooltip.show {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex; }\n\n#mainNav.navbar-dark .navbar-collapse .navbar-sidenav .nav-link-collapse:after {\n  color: #868e96; }\n\n#mainNav.navbar-dark .navbar-collapse .navbar-sidenav > .nav-item > .nav-link {\n  color: #868e96; }\n\n#mainNav.navbar-dark .navbar-collapse .navbar-sidenav > .nav-item > .nav-link:hover {\n  color: #adb5bd; }\n\n#mainNav.navbar-dark .navbar-collapse .navbar-sidenav > .nav-item .sidenav-second-level > li > a,\n#mainNav.navbar-dark .navbar-collapse .navbar-sidenav > .nav-item .sidenav-third-level > li > a {\n  color: #868e96; }\n\n#mainNav.navbar-dark .navbar-collapse .navbar-sidenav > .nav-item .sidenav-second-level > li > a:focus, #mainNav.navbar-dark .navbar-collapse .navbar-sidenav > .nav-item .sidenav-second-level > li > a:hover,\n#mainNav.navbar-dark .navbar-collapse .navbar-sidenav > .nav-item .sidenav-third-level > li > a:focus,\n#mainNav.navbar-dark .navbar-collapse .navbar-sidenav > .nav-item .sidenav-third-level > li > a:hover {\n  color: #adb5bd; }\n\n#mainNav.navbar-dark .navbar-collapse .navbar-nav > .nav-item.dropdown > .nav-link:after {\n  color: #adb5bd; }\n\n@media (min-width: 992px) {\n  #mainNav.navbar-dark .navbar-collapse .navbar-sidenav {\n    background: #343a40; }\n\n  #mainNav.navbar-dark .navbar-collapse .navbar-sidenav li.active a {\n    color: white !important;\n    background-color: #495057; }\n\n  #mainNav.navbar-dark .navbar-collapse .navbar-sidenav li.active a:focus, #mainNav.navbar-dark .navbar-collapse .navbar-sidenav li.active a:hover {\n    color: white; }\n\n  #mainNav.navbar-dark .navbar-collapse .navbar-sidenav > .nav-item .sidenav-second-level,\n  #mainNav.navbar-dark .navbar-collapse .navbar-sidenav > .nav-item .sidenav-third-level {\n    background: #343a40; } }\n#mainNav.navbar-light .navbar-collapse .navbar-sidenav .nav-link-collapse:after {\n  color: rgba(0, 0, 0, 0.5); }\n\n#mainNav.navbar-light .navbar-collapse .navbar-sidenav > .nav-item > .nav-link {\n  color: rgba(0, 0, 0, 0.5); }\n\n#mainNav.navbar-light .navbar-collapse .navbar-sidenav > .nav-item > .nav-link:hover {\n  color: rgba(0, 0, 0, 0.7); }\n\n#mainNav.navbar-light .navbar-collapse .navbar-sidenav > .nav-item .sidenav-second-level > li > a,\n#mainNav.navbar-light .navbar-collapse .navbar-sidenav > .nav-item .sidenav-third-level > li > a {\n  color: rgba(0, 0, 0, 0.5); }\n\n#mainNav.navbar-light .navbar-collapse .navbar-sidenav > .nav-item .sidenav-second-level > li > a:focus, #mainNav.navbar-light .navbar-collapse .navbar-sidenav > .nav-item .sidenav-second-level > li > a:hover,\n#mainNav.navbar-light .navbar-collapse .navbar-sidenav > .nav-item .sidenav-third-level > li > a:focus,\n#mainNav.navbar-light .navbar-collapse .navbar-sidenav > .nav-item .sidenav-third-level > li > a:hover {\n  color: rgba(0, 0, 0, 0.7); }\n\n#mainNav.navbar-light .navbar-collapse .navbar-nav > .nav-item.dropdown > .nav-link:after {\n  color: rgba(0, 0, 0, 0.5); }\n\n@media (min-width: 992px) {\n  #mainNav.navbar-light .navbar-collapse .navbar-sidenav {\n    background: #f8f9fa; }\n\n  #mainNav.navbar-light .navbar-collapse .navbar-sidenav li.active a {\n    color: #000 !important;\n    background-color: #e9ecef; }\n\n  #mainNav.navbar-light .navbar-collapse .navbar-sidenav li.active a:focus, #mainNav.navbar-light .navbar-collapse .navbar-sidenav li.active a:hover {\n    color: #000; }\n\n  #mainNav.navbar-light .navbar-collapse .navbar-sidenav > .nav-item .sidenav-second-level,\n  #mainNav.navbar-light .navbar-collapse .navbar-sidenav > .nav-item .sidenav-third-level {\n    background: #f8f9fa; } }\n.card-body-icon {\n  position: absolute;\n  z-index: 0;\n  top: -25px;\n  right: -25px;\n  font-size: 5rem;\n  -webkit-transform: rotate(15deg);\n  transform: rotate(15deg); }\n\n@media (min-width: 576px) {\n  .card-columns {\n    -webkit-column-count: 1;\n            column-count: 1; } }\n@media (min-width: 768px) {\n  .card-columns {\n    -webkit-column-count: 2;\n            column-count: 2; } }\n@media (min-width: 1200px) {\n  .card-columns {\n    -webkit-column-count: 2;\n            column-count: 2; } }\n.card-login {\n  max-width: 25rem; }\n\n.card-register {\n  max-width: 40rem; }\n\nfooter.sticky-footer {\n  position: absolute;\n  right: 0;\n  bottom: 0;\n  width: 100%;\n  height: 56px;\n  background-color: #e9ecef;\n  line-height: 55px; }\n\n@media (min-width: 992px) {\n  footer.sticky-footer {\n    width: calc(100% - 250px); } }\n@media (min-width: 992px) {\n  body.sidenav-toggled footer.sticky-footer {\n    width: calc(100% - 55px); } }\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/components/navbar/navbar.component.html":
/***/ (function(module, exports) {

module.exports = "<!--Navbar for home-->\n<nav class=\"navbar navbar-expand-lg navbar-light fixed-top\" id=\"homeNav\">\n  <div class=\"container\">\n    <a class=\"navbar-brand js-scroll-trigger\" routerLink=\"\">Dupe Detective</a>\n      <button (click)=\"isCollapsed = !isCollapsed\"\n              class=\"navbar-toggler pull-xs-right hidden-sm-up\" type=\"button\"\n              aria-controls=\"bd-main-nav\"\n              aria-label=\"Toggle navigation\">\n      <i class=\"fa fa-bars\"></i>\n    </button>\n    <div class=\"navbar-toggleable-xs navbar-collapse\" id=\"bd-main-nav\"\n         [attr.aria-expanded]=\"!isCollapsed\" [ngClass]=\"{collapse: isCollapsed}\">\n      <ul class=\"navbar-nav ml-auto\">\n        <li (click)=\"isCollapsed = true\"  class=\"nav-item\" *ngIf=\"!isLoggedIn()\">\n          <a class=\"nav-link js-scroll-trigger\" routerLink=\"/\">Home</a>\n        </li>\n        <li (click)=\"isCollapsed = true\" class=\"nav-item\" *ngIf=\"isLoggedIn() && isGrader()\">\n        <a class=\"nav-link\" routerLink=\"/assignments\">Assignments</a>\n        </li>\n        <li (click)=\"isCollapsed = true\"  class=\"nav-item\" *ngIf=\"isLoggedIn() && isGrader()\">\n          <a class=\"nav-link js-scroll-trigger\" routerLink=\"/submissions\">Submissions</a>\n        </li>\n        <li (click)=\"isCollapsed = true\"  class=\"nav-item dropdown\"  ngbDropdown  *ngIf=\"!isLoggedIn()\">\n        <a class=\"nav-link dropdown-toggle\" routerLink=\"\" id=\"dropdown01\" data-toggle=\"dropdown\"\n           aria-haspopup=\"true\" aria-expanded=\"false\"\n           ngbDropdownToggle>Login/Signup</a>\n        <div class=\"dropdown-menu\" aria-labelledby=\"dropdown01\" ngbDropdownMenu>\n        <a class=\"dropdown-item\" routerLink=\"/login\">Login</a>\n        <a class=\"dropdown-item\" routerLink=\"/register\">Signup</a>\n        </div>\n        </li>\n        <li (click)=\"isCollapsed = true\"  class=\"nav-item\" *ngIf=\"isLoggedIn() && !isGrader()\">\n          <a class=\"nav-link js-scroll-trigger\" routerLink=\"/submissions/new\">Upload Assignment</a>\n        </li>\n        <li (click)=\"isCollapsed = true\" *ngIf=\"isLoggedIn()\" class=\"nav-item\">\n          <a class=\"nav-link js-scroll-trigger\"  href=\"\" (click)=\"logout()\">Logout</a>\n        </li>\n      </ul>\n    </div>\n  </div>\n</nav>\n"

/***/ }),

/***/ "../../../../../src/app/components/navbar/navbar.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return NavbarComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_util__ = __webpack_require__("../../../../util/util.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_util___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_util__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var NavbarComponent = (function () {
    function NavbarComponent(router) {
        this.router = router;
        this.isCollapsed = true;
    }
    /**
     * On page load
     */
    NavbarComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.router.events.subscribe(function (event) {
            if (event instanceof __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* NavigationEnd */]) {
                console.log("Current Route: " + event.url);
                _this.currentRt = event.url;
            }
        });
    };
    /**
     * Fn to check if user loggedin
     * @returns {boolean} true or false
     */
    NavbarComponent.prototype.isLoggedIn = function () {
        return localStorage.getItem('currentUser') != null;
    };
    /**
     * Fn to check if user is grader
     * @returns {boolean} true or false
     */
    NavbarComponent.prototype.isGrader = function () {
        var tmp = localStorage.getItem("currentUser");
        return !!(tmp && !Object(__WEBPACK_IMPORTED_MODULE_2_util__["isUndefined"])(tmp) && JSON.parse(tmp)["grader"] === true);
    };
    /**
     * Logout from the site
     */
    NavbarComponent.prototype.logout = function () {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
        this.router.navigate(['/login']);
    };
    NavbarComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
            selector: 'app-navbar',
            template: __webpack_require__("../../../../../src/app/components/navbar/navbar.component.html"),
            styles: [__webpack_require__("../../../../../src/app/components/navbar/navbar.component.css")]
        })
        /**
         * Component that creates the nav bar
         */
        ,
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_router__["d" /* Router */]])
    ], NavbarComponent);
    return NavbarComponent;
}());



/***/ }),

/***/ "../../../../../src/app/components/register/register.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/components/register/register.component.html":
/***/ (function(module, exports) {

module.exports = "<br>\n<div class=\"container\">\n<div class=\"card card-register mx-auto mt-5\">\n  <div class=\"card-header\">Register an Account</div>\n  <div class=\"card-body\">\n    <form>\n      <div class=\"form-group\">\n        <div class=\"form-row\">\n            <label for=\"exampleInputName\">Name</label>\n            <input class=\"form-control\" id=\"exampleInputName\" [(ngModel)]=\"name\" name=\"name\" type=\"text\" aria-describedby=\"nameHelp\" placeholder=\"Enter name\">\n        </div>\n      </div>\n      <div class=\"form-group\">\n        <label for=\"exampleInputEmail\">Email address</label>\n        <input class=\"form-control\" [(ngModel)]=\"email\" name=\"email\" id=\"exampleInputEmail\" type=\"email\" aria-describedby=\"emailHelp\" placeholder=\"Enter email\">\n      </div>\n      <div class=\"form-group\">\n        <label for=\"exampleInputGrader\">Grader/Student</label>\n        <select [(ngModel)]=\"grader\" class=\"form-control\" id=\"exampleInputGrader\" name=\"grader\" aria-describedby=\"graderHelp\">\n          <option value=true selected>Grader</option>\n          <option value=false>Student</option>\n        </select>\n      </div>\n      <div class=\"form-group\">\n        <label for=\"exampleInputUsername\">Username</label>\n        <input [(ngModel)]=\"username\"  class=\"form-control\" id=\"exampleInputUsername\" type=\"text\" name=\"username\" aria-describedby=\"usernameHelp\" placeholder=\"Enter Username\">\n      </div>\n      <div class=\"form-group\">\n        <div class=\"form-row\">\n          <div class=\"col-md-6\">\n            <label for=\"exampleInputPassword1\">Password</label>\n            <input class=\"form-control\" [(ngModel)]=\"password\" id=\"exampleInputPassword1\" type=\"password\" name=\"password\" placeholder=\"Password\">\n          </div>\n          <div class=\"col-md-6\">\n            <label for=\"exampleConfirmPassword\">Confirm password</label>\n            <input class=\"form-control\" id=\"exampleConfirmPassword\" type=\"password\" placeholder=\"Confirm password\">\n          </div>\n        </div>\n      </div>\n      <a class=\"btn btn-primary btn-block white-text\" (click)=\"register()\">Register</a>\n    </form>\n    <div class=\"text-center\">\n      <a class=\"d-block small mt-3\" routerLink=\"/login\">Already a user? Login here</a>\n    </div>\n  </div>\n</div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/components/register/register.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RegisterComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_user_service__ = __webpack_require__("../../../../../src/app/services/user.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



/**
 * Register the user
 */
var RegisterComponent = (function () {
    function RegisterComponent(userService, router) {
        this.userService = userService;
        this.router = router;
        this.grader = false;
    }
    /**
     * On page load
     */
    RegisterComponent.prototype.ngOnInit = function () { };
    /**
     * Register the user
     */
    RegisterComponent.prototype.register = function () {
        var _this = this;
        var data = { "name": this.name, "email": this.email, "username": this.username, "password": this.password, "grader": this.grader };
        this.userService.createUser(data).subscribe(function (user) {
            console.log(user);
            localStorage.setItem("currentUser", JSON.stringify(user));
            if (user && user.grader) {
                _this.router.navigate(['/assignments']);
            }
            else if (user && !user.grader) {
                _this.router.navigate(['/submissions/new']);
            }
        });
    };
    RegisterComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
            selector: 'app-register',
            template: __webpack_require__("../../../../../src/app/components/register/register.component.html"),
            styles: [__webpack_require__("../../../../../src/app/components/register/register.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__services_user_service__["a" /* UserService */], __WEBPACK_IMPORTED_MODULE_2__angular_router__["d" /* Router */]])
    ], RegisterComponent);
    return RegisterComponent;
}());



/***/ }),

/***/ "../../../../../src/app/components/report/report.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "body {\n  font-size: medium; }\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/components/report/report.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"card mb-3\" *ngIf=\"selectedReport\">\n  <div class=\"card-header\">\n    <i class=\"fa fa-table\"></i> Report</div>\n  <div class=\"card-body\">\n    <form>\n      <div class=\"form-group\">\n        <div class=\"form-row\">\n          <label for=\"assignment\">Assignment</label>\n          <select class=\"form-control\" id=\"assignment\" name=\"assignment\" [(ngModel)]=\"selectedAssignment\" (change)=\"updateReport()\">\n            <option *ngFor=\"let assignment of assignments\" [ngValue]=\"assignment.id\">{{assignment.name}}</option>\n          </select>\n        </div>\n      </div>\n      <div class=\"row\">\n        <div class=\"col\">\n      <div class=\"form-group\" *ngIf=\"students1\">\n        <label for=\"student1\">Student 1</label>\n        <select class=\"form-control\" id=\"student1\" name=\"student1\" [(ngModel)]=\"student1\" (change)=\"updateReport()\">\n          <option *ngFor=\"let student of students1\" [ngValue]=\"student.id\">{{student.name}}</option>\n        </select>\n      </div>\n        </div>\n        <div class=\"col\">\n      <div class=\"form-group\" *ngIf=\"students2\">\n        <label for=\"student2\">Student 2</label>\n        <select class=\"form-control\" id=\"student2\" name=\"student2\" [(ngModel)]=\"student2\" (change)=\"updateReport()\">\n          <option *ngFor=\"let student of students2\" [ngValue]=\"student.id\">{{student.name}}</option>\n        </select>\n      </div>\n        </div>\n      </div>\n    </form>\n    <div class=\"row\" *ngIf=\"selectedReport && selectedReport.md5Result\">\n      <div class=\"col\">\n        <div class=\"alert alert-danger\" role=\"alert\">\n          <strong>This is a live one!</strong> The files are an exact copy!\n        </div>\n      </div>\n    </div>\n    <div class=\"row\">\n      <div class=\"col\">\n        <div class=\"card text-white o-hidden h-100\" style=\"background-color: darkcyan\">\n          <div class=\"card-body\">\n            <div class=\"card-header\" style=\"background-color: transparent;font-size: larger \" *ngIf=\"selectedReport\">\n              {{overallScore*100 | number : '1.2-2'}}%\n            </div>\n            <div class=\"card-body-icon\" style=\"margin-top: 7px\">\n              <i class=\"fa fa-fw fa-comments\"></i> &nbsp; Overall Score\n            </div>\n            <div class=\"mr-5\"></div>\n          </div>\n        </div>\n      </div>\n    </div>\n    <br>\n    <!-- Icon Cards-->\n    <div class=\"row\">\n      <div class=\"col-xl-3 col-sm-6 mb-3\">\n        <div class=\"card text-white bg-primary o-hidden h-100\">\n          <div class=\"card-body\">\n            <div class=\"card-body-icon\">\n              Structure\n            </div>\n            <div class=\"mr-5\" *ngIf=\"selectedReport\"> {{structureScore*100 | number : '1.2-2'}}%</div>\n          </div>\n          <a class=\"card-footer text-white clearfix small z-1\" (click)=\"open('structure')\">\n            <span class=\"float-left\">View Details</span>\n            <span class=\"float-right\">\n                <i class=\"fa fa-angle-right\"></i>\n              </span>\n          </a>\n        </div>\n      </div>\n      <div class=\"col-xl-3 col-sm-6 mb-3\">\n        <div class=\"card text-white bg-warning o-hidden h-100\">\n          <div class=\"card-body\">\n            <div class=\"card-body-icon\">\n              Methods\n            </div>\n            <div class=\"mr-5\" *ngIf=\"selectedReport\">{{methodScore*100 | number : '1.2-2'}}%</div>\n          </div>\n          <a class=\"card-footer text-white clearfix small z-1\" (click)=\"open('method')\">\n            <span class=\"float-left\">View Details</span>\n            <span class=\"float-right\">\n                <i class=\"fa fa-angle-right\"></i>\n              </span>\n          </a>\n        </div>\n      </div>\n      <div class=\"col-xl-3 col-sm-6 mb-3\">\n        <div class=\"card text-white bg-success o-hidden h-100\">\n          <div class=\"card-body\">\n            <div class=\"card-body-icon\">\n              Loop/Cond\n            </div>\n            <div class=\"mr-5\" *ngIf=\"selectedReport\">{{loopScore * 100 | number : '1.2-2'}}%</div>\n          </div>\n          <a class=\"card-footer text-white clearfix small z-1\" (click)=\"open('loop')\">\n            <span class=\"float-left\">View Details</span>\n            <span class=\"float-right\">\n                <i class=\"fa fa-angle-right\"></i>\n              </span>\n          </a>\n        </div>\n      </div>\n      <div class=\"col-xl-3 col-sm-6 mb-3\">\n        <div class=\"card text-white bg-danger o-hidden h-100\">\n          <div class=\"card-body\">\n            <div class=\"card-body-icon\">\n              Winnowing\n            </div>\n            <div class=\"mr-5\" *ngIf=\"selectedReport\">{{winnowingScore * 100 | number : '1.2-2'}}%</div>\n          </div>\n          <a class=\"card-footer text-white clearfix small z-1\" (click)=\"open('winnowing')\">\n            <span class=\"float-left\">View Details</span>\n            <span class=\"float-right\">\n                <i class=\"fa fa-angle-right\"></i>\n              </span>\n          </a>\n        </div>\n      </div>\n    </div>\n    <div class=\"row align-content-center\" *ngIf=\"enableAnalytics\">\n      <div class=\"col\" style=\"text-align: center;\">\n      <div class=\"alert alert-success\" role=\"alert\">\n        <h4 class=\"alert-heading\">Help us help you.</h4>\n        <p>Is this Plagiarised?</p>\n        <select class=\"form-control\" id=\"plagiarised\" name=\"plagiarised\" [(ngModel)]=\"plagiarised\" (change)=\"updateModel()\">\n          <option value=false>No</option>\n          <option value=true>Yes</option>\n        </select>\n        <br>\n        <p>SmartScore&trade;: {{smartScore | number : '1.2-2'}} (experimental)<p>\n      </div>\n    </div>\n    </div>\n    <div class=\"row align-content-center\"><div class=\"col\" style=\"text-align: center;\">\n      <a class=\"btn btn-primary white-text\" [href]=\"downloadLink\" download=\"{{selectedReport.submissionId}}_report.json\">Download Report</a>\n    </div></div>\n  </div>\n</div>\n\n<div class=\"card mb-3\" *ngIf=\"!selectedReport\">\n  <div class=\"card-header\">\n    <i class=\"fa fa-table\"></i> Report</div>\n  <div class=\"card-body\">\n    <p>No Reports Available</p>\n  </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/components/report/report.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ReportComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common__ = __webpack_require__("../../../common/esm5/common.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_report_service__ = __webpack_require__("../../../../../src/app/services/report.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__ng_bootstrap_ng_bootstrap__ = __webpack_require__("../../../../@ng-bootstrap/ng-bootstrap/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__comparedocuments_comparedocuments_component__ = __webpack_require__("../../../../../src/app/components/comparedocuments/comparedocuments.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__services_assignment_service__ = __webpack_require__("../../../../../src/app/services/assignment.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__services_user_service__ = __webpack_require__("../../../../../src/app/services/user.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__services_submission_service__ = __webpack_require__("../../../../../src/app/services/submission.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__angular_platform_browser__ = __webpack_require__("../../../platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__services_analytics_service__ = __webpack_require__("../../../../../src/app/services/analytics.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};











/**
 * The Component that creates the ModelReport page
 */
var ReportComponent = (function () {
    function ReportComponent(route, reportService, location, modalService, assignmentService, userService, submissionService, analyticsService, sanitizer) {
        this.route = route;
        this.reportService = reportService;
        this.location = location;
        this.modalService = modalService;
        this.assignmentService = assignmentService;
        this.userService = userService;
        this.submissionService = submissionService;
        this.analyticsService = analyticsService;
        this.sanitizer = sanitizer;
        this.plagiarised = false;
        this.winnowingScore = 0;
        this.structureScore = 0;
        this.loopScore = 0;
        this.methodScore = 0;
        this.overallScore = 0;
        this.analyzed = false;
        this.smartScore = 0;
        this.enableAnalytics = false;
    }
    /**
     * On page load
     */
    ReportComponent.prototype.ngOnInit = function () {
        this.getReport();
        this.getAllAssignments();
        this.updateUsers();
    };
    /**
     * Gets all the users
     */
    ReportComponent.prototype.updateUsers = function () {
        var _this = this;
        this.userService.getUsers().subscribe(function (users) {
            _this.students1 = users.filter(function (u) { return u.grader === false && u.id != _this.student2; });
            _this.students2 = users.filter(function (u) { return u.grader === false && u.id != _this.student1; });
        });
    };
    /**
     * Gets all the assignments
     */
    ReportComponent.prototype.getAllAssignments = function () {
        var _this = this;
        this.assignmentService.getAssignments().subscribe(function (assignments) { return _this.assignments = assignments; });
    };
    /**
     * Get student from submission
     */
    ReportComponent.prototype.getStudentsFromSubmission = function () {
        var _this = this;
        this.submissionService.getSubmission(this.selectedReport.refFileId)
            .subscribe(function (submission) {
            _this.student1 = submission.studentId;
            _this.selectedAssignment = submission.assignmentId;
        });
        this.submissionService.getSubmission(this.selectedReport.similarFileId)
            .subscribe(function (submission) {
            _this.student2 = submission["studentId"];
        });
    };
    /**
     * Get the assignment
     */
    ReportComponent.prototype.getReport = function () {
        var _this = this;
        if (this.route.snapshot.paramMap.get('submissionId') != null && this.route.snapshot.paramMap.get('assignmentId') !== "") {
            var submissionId = this.route.snapshot.paramMap.get('submissionId');
            var assignmentId = this.route.snapshot.paramMap.get('assignmentId');
            this.submissionService.getReportsBySubmissionId(submissionId)
                .subscribe(function (reports) {
                _this.reports = reports;
                if (reports.length > 0) {
                    _this.selectedReport = reports[0];
                    _this.generateDownloadUrl();
                    _this.getStudentsFromSubmission();
                    _this.fetchScores();
                }
            });
        }
        else {
            this.reportService.getAllReports()
                .subscribe(function (reports) {
                _this.reports = reports;
                _this.selectedReport = reports[0];
                _this.generateDownloadUrl();
                _this.getStudentsFromSubmission();
                _this.fetchScores();
            });
        }
    };
    /**
     * Fetch scores from report obj
     */
    ReportComponent.prototype.fetchScores = function () {
        var _this = this;
        for (var _i = 0, _a = this.selectedReport.models; _i < _a.length; _i++) {
            var model = _a[_i];
            // console.log(model.mothis.getStudentsFromSubmission();del)
            switch (model.model) {
                case 1:
                    this.structureScore = model.score;
                    break;
                case 2:
                    this.loopScore = model.score;
                    break;
                case 3:
                    this.methodScore = model.score;
                    break;
                case 5:
                    this.winnowingScore = model.score;
                    break;
            }
        }
        this.getOverallScore();
        var scores = [this.selectedReport.md5Result ? 1 : 0, this.structureScore, this.loopScore,
            this.methodScore, this.winnowingScore];
        this.analyticsService.getPrediction(scores).subscribe(function (pred) {
            _this.smartScore = pred.prediction;
            _this.enableAnalytics = true;
        });
    };
    /**
     * Get overall score from the model
     */
    ReportComponent.prototype.getOverallScore = function () {
        this.overallScore = this.selectedReport.overallScore;
    };
    /**
     * Get the assignment
     * @param {string} assignmentId
     * @param {string} refFileId
     * @param {string} similarFileId
     */
    ReportComponent.prototype.getReportByIds = function (assignmentId, refFileId, similarFileId) {
        var _this = this;
        if (refFileId !== similarFileId) {
            console.log("ref file id: " + refFileId + ", similar file id: " + similarFileId);
            this.reportService.getReportByIds(refFileId, similarFileId)
                .subscribe(function (report) {
                _this.selectedReport = report;
                _this.generateDownloadUrl();
                _this.fetchScores();
            });
        }
    };
    /**
     * update ModelReport on change
     */
    ReportComponent.prototype.updateReport = function () {
        var _this = this;
        this.submissionService.getSubmissionByStudentAssignment(this.selectedAssignment, this.student1).subscribe(function (submission) {
            var refFileId = submission.id;
            _this.submissionService.getSubmissionByStudentAssignment(_this.selectedAssignment, _this.student2).subscribe(function (submission2) {
                var similarFileId = submission2.id;
                _this.getReportByIds(_this.selectedAssignment, refFileId, similarFileId);
                _this.updateUsers();
            });
        });
    };
    /**
     * Update the model when user clicks on an option
     */
    ReportComponent.prototype.updateModel = function () {
        var _this = this;
        console.log("Updating model.");
        var scores = [this.selectedReport.md5Result ? 1 : 0, this.structureScore, this.loopScore,
            this.methodScore, this.winnowingScore];
        this.analyticsService.fitPredict(scores, this.plagiarised ? 1 : 0).subscribe(function (pred) { return _this.smartScore = pred.prediction; });
    };
    /**
     * Generate a json file for the selected report
     */
    ReportComponent.prototype.generateDownloadUrl = function () {
        var theJSON = JSON.stringify(this.selectedReport);
        this.downloadLink = this.sanitizer.bypassSecurityTrustUrl("data:text/json;charset=UTF-8," + encodeURIComponent(theJSON));
    };
    /**
     * Go back to previous page
     */
    ReportComponent.prototype.goBack = function () {
        this.location.back();
    };
    /**
     * Open the modal to display comparison
     */
    ReportComponent.prototype.open = function (model) {
        var modalRef = this.modalService.open(__WEBPACK_IMPORTED_MODULE_5__comparedocuments_comparedocuments_component__["a" /* ComparedocumentsComponent */]);
        modalRef.componentInstance.model = model;
        modalRef.componentInstance.refFileId = this.selectedReport["refFileId"];
        modalRef.componentInstance.similarFileId = this.selectedReport["similarFileId"];
        modalRef.componentInstance.student1 = this.student1;
        modalRef.componentInstance.student2 = this.student2;
    };
    ReportComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
            selector: 'app-submission-list',
            template: __webpack_require__("../../../../../src/app/components/report/report.component.html"),
            styles: [__webpack_require__("../../../../../src/app/components/report/report.component.css")],
            entryComponents: [__WEBPACK_IMPORTED_MODULE_5__comparedocuments_comparedocuments_component__["a" /* ComparedocumentsComponent */]]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_router__["a" /* ActivatedRoute */],
            __WEBPACK_IMPORTED_MODULE_3__services_report_service__["a" /* ReportService */],
            __WEBPACK_IMPORTED_MODULE_2__angular_common__["f" /* Location */],
            __WEBPACK_IMPORTED_MODULE_4__ng_bootstrap_ng_bootstrap__["b" /* NgbModal */],
            __WEBPACK_IMPORTED_MODULE_6__services_assignment_service__["a" /* AssignmentService */],
            __WEBPACK_IMPORTED_MODULE_7__services_user_service__["a" /* UserService */],
            __WEBPACK_IMPORTED_MODULE_8__services_submission_service__["a" /* SubmissionService */],
            __WEBPACK_IMPORTED_MODULE_10__services_analytics_service__["a" /* AnalyticsService */],
            __WEBPACK_IMPORTED_MODULE_9__angular_platform_browser__["b" /* DomSanitizer */]])
    ], ReportComponent);
    return ReportComponent;
}());



/***/ }),

/***/ "../../../../../src/app/components/submissionlist/submissionlist.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/components/submissionlist/submissionlist.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"card mb-3\">\n  <div class=\"card-header\">\n    <i class=\"fa fa-table\"></i> My Submissions</div>\n  <div class=\"card-body\">\n    <div class=\"table-responsive\">\n      <table class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">\n        <thead>\n        <tr>\n          <th>Id</th>\n          <!--<th>Name</th>-->\n          <th>User</th>\n          <th>Assignment</th>\n          <th>Submitted On</th>\n        </tr>\n        </thead>\n        <tbody>\n        <tr *ngFor=\"let submission of submissions\">\n\n          <td><a routerLink=\"/assignment/{{submission.assignmentId}}/submission/{{submission.id}}/reports\">{{submission.id}}</a></td>\n          <!--<td>{{submission.name | uppercase}}</td>-->\n          <td>{{users[submission.id]}}</td>\n          <td>{{assignments[submission.id]}}</td>\n          <td>{{submission.submittedOn}}</td>\n          <td>{{submission.filename}}</td>\n        </tr>\n        </tbody>\n      </table>\n    </div>\n  </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/components/submissionlist/submissionlist.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SubmissionListComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__services_submission_service__ = __webpack_require__("../../../../../src/app/services/submission.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_assignment_service__ = __webpack_require__("../../../../../src/app/services/assignment.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__services_user_service__ = __webpack_require__("../../../../../src/app/services/user.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





/**
 * List all Submissions
 */
var SubmissionListComponent = (function () {
    function SubmissionListComponent(route, submissionService, assignmentService, userService) {
        this.route = route;
        this.submissionService = submissionService;
        this.assignmentService = assignmentService;
        this.userService = userService;
        this.users = {};
        this.assignments = {};
    }
    /**
     * On page load
     */
    SubmissionListComponent.prototype.ngOnInit = function () {
        this.getSubmissions();
    };
    /**
     * Get all submissions
     */
    SubmissionListComponent.prototype.getSubmissions = function () {
        var _this = this;
        if (this.route.snapshot.paramMap.get('assignmentId') != null && this.route.snapshot.paramMap.get('assignmentId') !== "") {
            var id = this.route.snapshot.paramMap.get('assignmentId');
            console.log(id);
            this.assignmentService.getSubmissionsByAssignmentId(id)
                .subscribe(function (submissions) {
                _this.submissions = submissions;
                _this.getUsers();
                _this.getAssignments();
            });
        }
        else {
            this.submissionService.getAllSubmissions()
                .subscribe(function (submissions) {
                _this.submissions = submissions;
                _this.getUsers();
                _this.getAssignments();
            });
        }
    };
    /**
     * Get users of submissions
     */
    SubmissionListComponent.prototype.getUsers = function () {
        var _this = this;
        var _loop_1 = function (submission) {
            this_1.userService.getUserById(submission.studentId).subscribe(function (u) {
                _this.users[submission.id] = u.name;
            });
        };
        var this_1 = this;
        for (var _i = 0, _a = this.submissions; _i < _a.length; _i++) {
            var submission = _a[_i];
            _loop_1(submission);
        }
    };
    /**
     * Get assignment of submissions
     */
    SubmissionListComponent.prototype.getAssignments = function () {
        var _this = this;
        var _loop_2 = function (submission) {
            this_2.assignmentService.getAssignment(submission.assignmentId).subscribe(function (a) {
                _this.assignments[submission.id] = a.name;
            });
        };
        var this_2 = this;
        for (var _i = 0, _a = this.submissions; _i < _a.length; _i++) {
            var submission = _a[_i];
            _loop_2(submission);
        }
    };
    SubmissionListComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
            selector: 'app-submission-list',
            template: __webpack_require__("../../../../../src/app/components/submissionlist/submissionlist.component.html"),
            styles: [__webpack_require__("../../../../../src/app/components/submissionlist/submissionlist.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_router__["a" /* ActivatedRoute */],
            __WEBPACK_IMPORTED_MODULE_2__services_submission_service__["a" /* SubmissionService */],
            __WEBPACK_IMPORTED_MODULE_3__services_assignment_service__["a" /* AssignmentService */],
            __WEBPACK_IMPORTED_MODULE_4__services_user_service__["a" /* UserService */]])
    ], SubmissionListComponent);
    return SubmissionListComponent;
}());



/***/ }),

/***/ "../../../../../src/app/components/uploadsubmission/uploadsubmission.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/components/uploadsubmission/uploadsubmission.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"card mx-auto mt-5\">\n  <div class=\"card-header\">Upload Submission</div>\n  <div class=\"card-body\">\n    <form>\n      <div class=\"form-group\">\n        <label for=\"InputAssignment\">Assignment</label>\n        <select [(ngModel)]=\"assignmentId\" class=\"form-control\" name=\"assignment\" id=\"InputAssignment\" aria-describedby=\"assignmentHelp\">\n          <option *ngFor=\"let assignment of assignments\" value={{assignment.id}}>{{assignment.name}}</option>\n        </select>\n      </div>\n      <div class=\"form-group\">\n        <label for=\"InputFile\">File</label>\n        <input type=\"file\" class=\"form-control\" id=\"InputFile\" (change)=\"fileChange($event)\" name=\"file\" />\n      </div>\n<a class=\"btn btn-primary btn-block white-text\" (click)=\"upload()\">Upload!</a>\n    </form>\n  </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/components/uploadsubmission/uploadsubmission.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return UploadSubmissionComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_submission_service__ = __webpack_require__("../../../../../src/app/services/submission.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__services_assignment_service__ = __webpack_require__("../../../../../src/app/services/assignment.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common__ = __webpack_require__("../../../common/esm5/common.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




/**
 * Upload submission component
 */
var UploadSubmissionComponent = (function () {
    function UploadSubmissionComponent(submissionService, assignmentService, location) {
        this.submissionService = submissionService;
        this.assignmentService = assignmentService;
        this.location = location;
    }
    /**
     * On page load
     */
    UploadSubmissionComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.userId = JSON.parse(localStorage.getItem('currentUser'))["id"];
        this.assignmentService.getAssignments().subscribe(function (assignments) {
            _this.assignments = assignments;
            _this.assignmentId = assignments && assignments.length > 0 ? _this.assignments[0].id : null;
        });
    };
    /**
     * on file change read it tt
     * @param $event
     */
    UploadSubmissionComponent.prototype.fileChange = function ($event) {
        this.readThis($event.target);
    };
    /**
     * Read the file contents
     * @param inputValue list of files
     */
    UploadSubmissionComponent.prototype.readThis = function (inputValue) {
        var _this = this;
        var file = inputValue.files[0];
        this.filename = inputValue.files[0].name;
        var myReader = new FileReader();
        myReader.onloadend = function (e) {
            _this.fileContent = myReader.result;
        };
        myReader.readAsText(file);
    };
    /**
     * Upload the submission
     */
    UploadSubmissionComponent.prototype.upload = function () {
        if (this.fileContent != null || this.filename != null || this.assignmentId != null || this.userId != null) {
            this.submissionService.uploadSubmission({ "filename": this.filename, "filecontent": this.fileContent,
                "assignmentId": this.assignmentId, "studentId": this.userId, "submittedOn": new Date().toJSON(), "checksum": "4ghvg77" }).subscribe(function (data) {
                console.log('success');
                location.reload();
            });
        }
    };
    UploadSubmissionComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
            selector: 'app-upload-submission',
            template: __webpack_require__("../../../../../src/app/components/uploadsubmission/uploadsubmission.component.html"),
            styles: [__webpack_require__("../../../../../src/app/components/uploadsubmission/uploadsubmission.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__services_submission_service__["a" /* SubmissionService */],
            __WEBPACK_IMPORTED_MODULE_2__services_assignment_service__["a" /* AssignmentService */],
            __WEBPACK_IMPORTED_MODULE_3__angular_common__["f" /* Location */]])
    ], UploadSubmissionComponent);
    return UploadSubmissionComponent;
}());



/***/ }),

/***/ "../../../../../src/app/services/alert.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AlertService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Subject__ = __webpack_require__("../../../../rxjs/_esm5/Subject.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



/**
 * Handle Alerts
 */
var AlertService = (function () {
    /**
     * On load
     * @param {Router} router
     */
    function AlertService(router) {
        var _this = this;
        this.router = router;
        this.subject = new __WEBPACK_IMPORTED_MODULE_2_rxjs_Subject__["a" /* Subject */]();
        this.keepAfterNavigationChange = false;
        // clear alert message on route change
        router.events.subscribe(function (event) {
            if (event instanceof __WEBPACK_IMPORTED_MODULE_1__angular_router__["c" /* NavigationStart */]) {
                if (_this.keepAfterNavigationChange) {
                    // only keep for a single location change
                    _this.keepAfterNavigationChange = false;
                }
                else {
                    // clear alert
                    _this.subject.next();
                }
            }
        });
    }
    /**
     * If success
     * @param {string} message
     * @param {boolean} keepAfterNavigationChange
     */
    AlertService.prototype.success = function (message, keepAfterNavigationChange) {
        if (keepAfterNavigationChange === void 0) { keepAfterNavigationChange = false; }
        this.keepAfterNavigationChange = keepAfterNavigationChange;
        this.subject.next({ type: 'success', text: message });
    };
    /**
     * If error
     * @param {string} message
     * @param {boolean} keepAfterNavigationChange
     */
    AlertService.prototype.error = function (message, keepAfterNavigationChange) {
        if (keepAfterNavigationChange === void 0) { keepAfterNavigationChange = false; }
        this.keepAfterNavigationChange = keepAfterNavigationChange;
        this.subject.next({ type: 'error', text: message });
    };
    /**
     * Get the message
     * @returns {Observable<any>}
     */
    AlertService.prototype.getMessage = function () {
        return this.subject.asObservable();
    };
    AlertService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_router__["d" /* Router */]])
    ], AlertService);
    return AlertService;
}());



/***/ }),

/***/ "../../../../../src/app/services/analytics.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AnalyticsService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


// HTTP POST Options
var httpOptions = {
    headers: new __WEBPACK_IMPORTED_MODULE_1__angular_common_http__["c" /* HttpHeaders */]({ 'Content-Type': 'application/json' })
};
/**
 * Analytics Service that performs all communication related to Analytics server
 */
var AnalyticsService = (function () {
    function AnalyticsService(http) {
        this.http = http;
        this.predictUrl = 'http://localhost:3000/predict';
        this.fitUrl = 'http://localhost:3000/fit';
    }
    /**
     * Get the prediction from server
     * @returns {Observable<Prediction>}
     */
    AnalyticsService.prototype.getPrediction = function (scores) {
        var data = { "train": scores };
        return this.http.post(this.predictUrl, data);
    };
    /**
     * Train with the new data and get the prediction from server
     * @returns {Observable<Prediction>}
     */
    AnalyticsService.prototype.fitPredict = function (scores, label) {
        var data = { "train": scores, "label": label };
        return this.http.post(this.fitUrl, data);
    };
    AnalyticsService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["a" /* HttpClient */]])
    ], AnalyticsService);
    return AnalyticsService;
}());



/***/ }),

/***/ "../../../../../src/app/services/assignment.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AssignmentService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_observable_of__ = __webpack_require__("../../../../rxjs/_esm5/observable/of.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_operators__ = __webpack_require__("../../../../rxjs/_esm5/operators/index.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var httpOptions = {
    headers: new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["c" /* HttpHeaders */]({ 'Content-Type': 'application/json' })
};
/**
 * Assignment Service that performs all communication related to assignment with the server
 */
var AssignmentService = (function () {
    /**
     * Default Constructor
     * @param {HttpClient} http the http client service
     */
    function AssignmentService(http) {
        this.http = http;
        this.assignmentUrl = 'http://localhost:8080/api/assignments'; // URL to com.dupedetective.web api
    }
    /**
     * Get all the assignments
     * @returns {Observable<Assignment[]>} an Observable for the array of Assignments
     */
    AssignmentService.prototype.getAssignments = function () {
        return this.http.get(this.assignmentUrl)
            .pipe(Object(__WEBPACK_IMPORTED_MODULE_3_rxjs_operators__["a" /* catchError */])(this.handleError('getAssignments', [])));
    };
    /**
     * GET assignment by id. Will 404 if id not found
     * @param {number} id the id of the assignment to retrieve
     * @returns {Observable<Assignment>} an Observable for the Assignments
     */
    AssignmentService.prototype.getAssignment = function (id) {
        var url = this.assignmentUrl + "/" + id;
        return this.http.get(url).pipe(Object(__WEBPACK_IMPORTED_MODULE_3_rxjs_operators__["a" /* catchError */])(this.handleError("getAssignment id=" + id)));
    };
    /**
     * Create an assignment
     * @param data object
     * @returns {Observable<Assignment>}
     */
    AssignmentService.prototype.createAssignment = function (data) {
        return this.http.post(this.assignmentUrl, data, httpOptions).pipe(Object(__WEBPACK_IMPORTED_MODULE_3_rxjs_operators__["a" /* catchError */])(this.handleError('createAssignment')));
    };
    /**
     * Analyze assignment with given id
     * @param {string} id
     * @returns {Observable<String>}
     */
    AssignmentService.prototype.analyze = function (id) {
        return this.http.post(this.assignmentUrl + "/" + id + "/analyze", {}, httpOptions).pipe(Object(__WEBPACK_IMPORTED_MODULE_3_rxjs_operators__["a" /* catchError */])(this.handleError('analyze')));
    };
    /**
     * GET submissions for an assignment by id. Will 404 if id not found
     * @param {number} id the id of the assignment to retrieve
     * @returns {Observable<Submission[]>} an Observable for the Assignments
     */
    AssignmentService.prototype.getSubmissionsByAssignmentId = function (id) {
        var url = this.assignmentUrl + "/" + id + "/submissions";
        return this.http.get(url).pipe(Object(__WEBPACK_IMPORTED_MODULE_3_rxjs_operators__["a" /* catchError */])(this.handleError("getSubmission id=" + id)));
    };
    /**
     * Handle Http operation that failed.
     * Let the app continue.
     * @param operation - name of the operation that failed
     * @param result - optional value to return as the observable result
     */
    AssignmentService.prototype.handleError = function (operation, result) {
        if (operation === void 0) { operation = 'operation'; }
        return function (error) {
            console.error(error); // log to console instead
            // Let the app keep running by returning an empty result.
            return Object(__WEBPACK_IMPORTED_MODULE_1_rxjs_observable_of__["a" /* of */])(result);
        };
    };
    AssignmentService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_common_http__["a" /* HttpClient */]])
    ], AssignmentService);
    return AssignmentService;
}());



/***/ }),

/***/ "../../../../../src/app/services/report.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ReportService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_observable_of__ = __webpack_require__("../../../../rxjs/_esm5/observable/of.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_operators__ = __webpack_require__("../../../../rxjs/_esm5/operators/index.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var httpOptions = {
    headers: new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["c" /* HttpHeaders */]({ 'Content-Type': 'application/json' })
};
/**
 * ModelReport Service that performs all communication related to reports with the server
 */
var ReportService = (function () {
    /**
     * Default Constructor
     * @param {HttpClient} http the http client service
     */
    function ReportService(http) {
        this.http = http;
        this.reportUrl = 'http://localhost:8080/api/reports'; // URL to com.dupedetective.web api
    }
    /**
     * Get all the reports
     * @returns {Observable<Report[]>} an Observable for the array of Reports
     */
    ReportService.prototype.getAllReports = function () {
        return this.http.get(this.reportUrl)
            .pipe(Object(__WEBPACK_IMPORTED_MODULE_3_rxjs_operators__["a" /* catchError */])(this.handleError('getReport', [])));
    };
    /**
     * GET report by id. Will 404 if id not found
     * @param {number} id the id of the report to retrieve
     * @returns {Observable<Report>} an Observable for the Report
     */
    ReportService.prototype.getReport = function (id) {
        var url = this.reportUrl + "/" + id;
        return this.http.get(url).pipe(Object(__WEBPACK_IMPORTED_MODULE_3_rxjs_operators__["a" /* catchError */])(this.handleError("getReport id=" + id)));
    };
    /**
     * GET report by assignment, ref file, similar file id. Will 404 if id not found
     * @param {string} refFileId
     * @param {string} similarFileId
     * @returns {Observable<Report[]>}
     */
    ReportService.prototype.getReportByIds = function (refFileId, similarFileId) {
        var url = this.reportUrl + "/single?refFileId=" + refFileId + "&similarFileId=" + similarFileId;
        return this.http.get(url).pipe(Object(__WEBPACK_IMPORTED_MODULE_3_rxjs_operators__["a" /* catchError */])(this.handleError("getReport refFileId=" + refFileId + " similarFileId=" + similarFileId)));
    };
    /**
     * Handle Http operation that failed.
     * Let the app continue.
     * @param operation - name of the operation that failed
     * @param result - optional value to return as the observable result
     */
    ReportService.prototype.handleError = function (operation, result) {
        if (operation === void 0) { operation = 'operation'; }
        return function (error) {
            console.error(error); // log to console instead
            // Let the app keep running by returning an empty result.
            return Object(__WEBPACK_IMPORTED_MODULE_1_rxjs_observable_of__["a" /* of */])(result);
        };
    };
    ReportService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_common_http__["a" /* HttpClient */]])
    ], ReportService);
    return ReportService;
}());



/***/ }),

/***/ "../../../../../src/app/services/submission.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SubmissionService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_observable_of__ = __webpack_require__("../../../../rxjs/_esm5/observable/of.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_operators__ = __webpack_require__("../../../../rxjs/_esm5/operators/index.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var httpOptions = {
    headers: new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["c" /* HttpHeaders */]({ 'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + 'eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9....' })
};
/**
 * Submission Service that performs all communication related to submissions with the server
 */
var SubmissionService = (function () {
    /**
     * Default Constructor
     * @param {HttpClient} http the http client service
     */
    function SubmissionService(http) {
        this.http = http;
        this.submissionUrl = 'http://localhost:8080/api/submissions'; // URL to com.dupedetective.web api
    }
    /**
     * Get all the submissions
     * @returns {Observable<Submission[]>} an Observable for the array of Assignments
     */
    SubmissionService.prototype.getAllSubmissions = function () {
        return this.http.get(this.submissionUrl)
            .pipe(Object(__WEBPACK_IMPORTED_MODULE_3_rxjs_operators__["a" /* catchError */])(this.handleError('getAllSubmissions', [])));
    };
    /**
     * GET submissions for an assignment by id. Will 404 if id not found
     * @param {number} id the id of the assignment to retrieve
     * @returns {Observable<Submission[]>} an Observable for the Assignments
     */
    SubmissionService.prototype.getSubmission = function (id) {
        var url = this.submissionUrl + "/" + id;
        return this.http.get(url).pipe(Object(__WEBPACK_IMPORTED_MODULE_3_rxjs_operators__["a" /* catchError */])(this.handleError("getSubmission id=" + id)));
    };
    /**
     * GET submissions for an assignment by id. Will 404 if id not found
     * @param {number} id the id of the assignment to retrieve
     * @returns {Observable<Submission[]>} an Observable for the Assignments
     */
    SubmissionService.prototype.getSubmissions = function (id) {
        var url = this.submissionUrl + "?assignmentId=" + id;
        return this.http.get(url).pipe(Object(__WEBPACK_IMPORTED_MODULE_3_rxjs_operators__["a" /* catchError */])(this.handleError("getSubmission id=" + id)));
    };
    /**
     * Get Submission by student Id and Assignment ID
     * @param {string} assignmentId
     * @param {string} studentId
     * @returns {Observable<Submission>} A Submission
     */
    SubmissionService.prototype.getSubmissionByStudentAssignment = function (assignmentId, studentId) {
        var url = this.submissionUrl + "/student?assignmentId=" + assignmentId + "&studentId=" + studentId;
        return this.http.get(url).pipe(Object(__WEBPACK_IMPORTED_MODULE_3_rxjs_operators__["a" /* catchError */])(this.handleError("getSubmission assignmentId=" + assignmentId + " studentId=" + studentId)));
    };
    /**
     * Upload the given submission to server
     * @param data form data
     * @returns {Observable<any | any>}
     */
    SubmissionService.prototype.uploadSubmission = function (data) {
        // It is very important to leave the Content-Type empty
        // do not use headers.append('Content-Type', 'multipart/form-data');
        return this.http.post("" + this.submissionUrl, JSON.stringify(data), httpOptions)
            .pipe(Object(__WEBPACK_IMPORTED_MODULE_3_rxjs_operators__["a" /* catchError */])(this.handleError('uploadSubmission')));
    };
    /**
     * GET report by assignment, ref file, similar file id. Will 404 if id not found
     * @param {string} submissionId
     * @returns {Observable<Report[]>}
     */
    SubmissionService.prototype.getReportsBySubmissionId = function (submissionId) {
        var url = this.submissionUrl + "/" + submissionId + "/reports";
        return this.http.get(url)
            .pipe(Object(__WEBPACK_IMPORTED_MODULE_3_rxjs_operators__["a" /* catchError */])(this.handleError("getReport submissionId=" + submissionId)));
    };
    /**
     * Handle Http operation that failed.
     * Let the app continue.
     * @param operation - name of the operation that failed
     * @param result - optional value to return as the observable result
     */
    SubmissionService.prototype.handleError = function (operation, result) {
        if (operation === void 0) { operation = 'operation'; }
        return function (error) {
            console.error(error); // log to console instead
            // Let the app keep running by returning an empty result.
            return Object(__WEBPACK_IMPORTED_MODULE_1_rxjs_observable_of__["a" /* of */])(result);
        };
    };
    SubmissionService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_common_http__["a" /* HttpClient */]])
    ], SubmissionService);
    return SubmissionService;
}());



/***/ }),

/***/ "../../../../../src/app/services/user.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return UserService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_observable_of__ = __webpack_require__("../../../../rxjs/_esm5/observable/of.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_operators__ = __webpack_require__("../../../../rxjs/_esm5/operators/index.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var httpOptions = {
    headers: new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["c" /* HttpHeaders */]({ 'Content-Type': 'application/json' })
};
/**
 * User Service that performs all communication related to users with the server
 */
var UserService = (function () {
    function UserService(http) {
        this.http = http;
        this.userUrl = 'http://localhost:8080/api/users';
    }
    /**
     * Get all the users
     * @returns {Observable<User[]>} List of Users
     */
    UserService.prototype.getUsers = function () {
        return this.http.get(this.userUrl)
            .pipe(Object(__WEBPACK_IMPORTED_MODULE_3_rxjs_operators__["a" /* catchError */])(this.handleError('getUsers', [])));
    };
    /**
     * Get a user by username and password
     * @param {string} username
     * @param {string} password
     * @returns {Observable<User>}
     */
    UserService.prototype.getUser = function (username, password) {
        var url = this.userUrl + "/login?username=" + username + "&password=" + password;
        return this.http.get(url).pipe(Object(__WEBPACK_IMPORTED_MODULE_3_rxjs_operators__["a" /* catchError */])(this.handleError("getUser user=" + username)));
    };
    /**
     * Fetch a user by Id
     * @param {string} id
     * @returns {Observable<User>}
     */
    UserService.prototype.getUserById = function (id) {
        var url = this.userUrl + "/" + id;
        return this.http.get(url).pipe(Object(__WEBPACK_IMPORTED_MODULE_3_rxjs_operators__["a" /* catchError */])(this.handleError("getUser userId=" + id)));
    };
    /** Create a new user
     * @param data json object
     * @returns {Observable<User>} a user observable
     * */
    UserService.prototype.createUser = function (data) {
        return this.http.post(this.userUrl, data, httpOptions).pipe(Object(__WEBPACK_IMPORTED_MODULE_3_rxjs_operators__["a" /* catchError */])(this.handleError('updateUser')));
    };
    /**
     * Handle Http operation that failed.
     * Let the app continue.
     * @param operation - name of the operation that failed
     * @param result - optional value to return as the observable result
     */
    UserService.prototype.handleError = function (operation, result) {
        if (operation === void 0) { operation = 'operation'; }
        return function (error) {
            console.error(error); // log to console instead
            // Let the app keep running by returning an empty result.
            return Object(__WEBPACK_IMPORTED_MODULE_1_rxjs_observable_of__["a" /* of */])(result);
        };
    };
    UserService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_common_http__["a" /* HttpClient */]])
    ], UserService);
    return UserService;
}());



/***/ }),

/***/ "../../../../../src/assets/images/home-login-bg.jpg":
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "home-login-bg.6743856929b5238c5350.jpg";

/***/ }),

/***/ "../../../../../src/assets/images/home-top-bg.jpg":
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "home-top-bg.c56b8bcae0da5fcf91ae.jpg";

/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
var environment = {
    production: false
};


/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/esm5/platform-browser-dynamic.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("../../../../../src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_16" /* enableProdMode */])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map