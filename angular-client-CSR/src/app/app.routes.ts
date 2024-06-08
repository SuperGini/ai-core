import {Routes} from '@angular/router';
import {Mainpage} from "./components/mainpage/mainpage";
import {CarsPage} from "./components/mainpage/carspage/cars";
import {Info} from "./components/mainpage/infopage/info";
import {Spring} from "./components/mainpage/springpage/spring";

export const routes: Routes = [

    {
        path: "main",
        component: Mainpage,
        children: [
            {
                path: "cars",
                component: CarsPage,
                pathMatch: "full"
            },
            {
                path: "spring",
                component: Spring,
                pathMatch: "full"
            },
            {
                path: "info",
                component: Info,
                pathMatch: "full"
            }
        ]
    }


];
