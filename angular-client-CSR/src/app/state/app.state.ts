//use signals to store state and not observables

 import {signal} from "@angular/core";
import {CarResponse} from "../dto/car.response";

export const carResponse = signal<CarResponse>(null);
