import {inject, Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {CarResponse} from "../../dto/car.response";

@Injectable({providedIn: 'root'})
export class AiGateway {

    private httpclient = inject(HttpClient);

    postSpringQuestion(question: string): Observable<string> {
        return this.httpclient.post<string>('http://localhost:8080/question', question);
    }

    postCarInfo(carInfo: string): Observable<CarResponse> {
        console.log("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        return this.httpclient.post<CarResponse>(
            'http://localhost:8080/cars',
            null,
            {params: this.queryParams(carInfo)});
    }

    private queryParams (queryParam: string) {
        return new HttpParams()
            .set('car', queryParam);
    }


}
