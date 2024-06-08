import {Component, inject} from "@angular/core";
import {Left} from "../left/left";
import {Router, RouterOutlet} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {AiGateway} from "../../services/aigateway/ai.gateway";
import {carResponse, infoResponse, springResponse} from "../../state/app.state";
import {Request} from "../../dto/request";
import {Pages} from "../../dto/page";

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
    private router = inject(Router);

    postForCarInfo() {
        this.apiGateway.postCarInfo(this.search)
            .subscribe(x => carResponse.set(x)
            );
    }

    postForSpringResponse() {
        const question: Request = {question: this.search};
        this.apiGateway.postSpringQuestion(question)
            .subscribe(x => springResponse.set(x));
    }

    postForInfoResponse() {
        const question: Request = {question: this.search};
        this.apiGateway.postInfoQuestion(question)
            .subscribe(x => infoResponse.set(x));
    }

    postForResponse() {
        const getCurrentUrl = this.router.url.split("/");
        const sendRequestTo = getCurrentUrl[2];

        switch (sendRequestTo) {
            case Pages.SPRING:
                this.postForSpringResponse();
                break;
            case Pages.CARS:
                this.postForCarInfo();
                break;
            case Pages.INFO:
                this.postForInfoResponse();
                break;
        }

    }
}
