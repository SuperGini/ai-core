import {Component} from "@angular/core";
import {infoResponse, springResponse} from "../../../state/app.state";

@Component({
    selector: "info",
    templateUrl: "info.html",
    styleUrl: "info.css",
    standalone: true
})
export class Info {


    protected readonly infoResponse = infoResponse;
    protected readonly springResponse = springResponse;
}
