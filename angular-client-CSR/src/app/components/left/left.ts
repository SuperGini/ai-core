import {Component, inject} from "@angular/core";
import {Router} from "@angular/router";


@Component({
    selector: "left",
    templateUrl: "left.html",
    styleUrl: "left.css",
    standalone: true
})
export class Left {

    private router = inject(Router);

    redirectCarsPage() {
        this.router.navigate(['main/cars']);
    }

    redirectInfoPage() {
        this.router.navigate(['main/info']);
    }

    redirectSpringPage() {
        this.router.navigate(['main/spring']);
    }

}
