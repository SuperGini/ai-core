//use signals to store state and not observables

import {signal} from "@angular/core";
import {CarResponse} from "../dto/car.response";
import {Response} from "../dto/response";

export const carResponse = signal<CarResponse>(null);
export const springResponse = signal<Response>(null);
export const infoResponse = signal<Response>(null);
