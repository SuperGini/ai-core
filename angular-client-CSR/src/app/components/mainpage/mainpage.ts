import {Component} from "@angular/core";
import {Left} from "../left/left";
import {RouterOutlet} from "@angular/router";

@Component({
    selector: "main-page",
    templateUrl: "mainpage.html",
    styleUrl: "mainpage.css",
    imports: [
        Left,
        RouterOutlet
    ],
    standalone: true
})
export class Mainpage {



}
