import {Component, inject} from "@angular/core";
import {Left} from "../left/left";
import {RouterOutlet} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {AiGateway} from "../../services/aigateway/ai.gateway";
import {carResponse} from "../../state/app.state";

@Component({
    selector: "main-page",
    templateUrl: "mainpage.html",
    styleUrl: "mainpage.css",
    imports: [
        Left,
        RouterOutlet,
        FormsModule
    ],
    standalone: true
})
export class Mainpage {

    search: string;

    private apiGateway = inject(AiGateway);

    postForCarInfo() {
        this.apiGateway.postCarInfo(this.search)
            .subscribe(x => carResponse.set(x)
            );
    }
}
