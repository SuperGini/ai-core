import {Component} from "@angular/core";
import {carResponse} from "../../../state/app.state";


@Component({
    selector: "cars",
    templateUrl: "./cars.html",
    styleUrl: "./cars.css",
    standalone: true
})
export class CarsPage {

    protected readonly carResponse = carResponse;
}
