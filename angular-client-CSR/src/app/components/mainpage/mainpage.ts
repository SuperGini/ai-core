import {Component, inject} from "@angular/core";
import {Left} from "../left/left";
import {RouterOutlet} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {AiGateway} from "../../services/aigateway/ai.gateway";
import {carResponse, springResponse} from "../../state/app.state";
import {SpringRequest} from "../../dto/spring.request";

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

    protected search: string;

    private apiGateway = inject(AiGateway);

    postForCarInfo() {
        this.apiGateway.postCarInfo(this.search)
            .subscribe(x => carResponse.set(x)
            );
    }

    postForSpringResponse() {
        const question: SpringRequest = {question: this.search};
        this.apiGateway.postSpringQuestion(question)
            .subscribe(x => springResponse.set(x));
    }
}
