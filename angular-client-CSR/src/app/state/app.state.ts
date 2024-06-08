//use signals to store state and not observables

import {signal} from "@angular/core";
import {CarResponse} from "../dto/car.response";
import {SpringResponse} from "../dto/spring.response";

export const carResponse = signal<CarResponse>(null);
export const springResponse = signal<SpringResponse>(null);
