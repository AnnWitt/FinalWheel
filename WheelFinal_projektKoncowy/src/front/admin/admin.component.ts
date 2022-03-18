import { Component, OnInit } from "@angular/core";

@Component({
    selector: 'admin',
    templateUrl: './admin.component.html'
    /*styleUrls: ['./fourth.component.css']*/
})
export class adminComponent implements OnInit {
    simpleObject = {name: 'test name', age: 20}

    moviesObject = {
        one: {
            name: 'Robin Hood',
            department: '',
            manager: null,
            salary: 200
        },
        two: {
            name: 'Arsene Wenger',
            department: 'Bar',
            manager: 'Friar Tuck',
            salary: 50
        }
    }

    moviesArray = [
        {
            name: 'Robin Hood',
            department: '',
            manager: null,
            salary: 200
        },
        {
            name: 'Arsene Wenger',
            department: 'Bar',
            manager: 'Friar Tuck',
            salary: 50
        }

    ]


    ngOnInit(): void {

    }

}
