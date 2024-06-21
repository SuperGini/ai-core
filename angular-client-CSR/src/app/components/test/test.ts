import {Component, inject, OnInit} from "@angular/core";
import {ActivatedRoute} from "@angular/router";

@Component({
    template: `
        <div><h1>TEST</h1></div>
    `,
    selector: "test",
    standalone: true
})
export class Test implements OnInit {

    private route = inject(ActivatedRoute);


    getPahVariable() {
        const variable = this.route.snapshot.params['id'];
        console.log(variable);
    }

    ngOnInit(): void {
        this.getPahVariable();
    }


}
