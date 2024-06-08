import {Component} from "@angular/core";
import {springResponse} from "../../../state/app.state";

@Component({
    selector: "spring",
    templateUrl: "./spring.html",
    styleUrl: "./spring.css",
    standalone: true

})
export class Spring {

    protected readonly springResponse = springResponse;

}
