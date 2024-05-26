
export interface CarResponse {
    manufacturer: string,
    carModels: CarModel []
}

export interface CarModel {
    modelType: string,
    topSpeed: string,
    engineType: string,
    startProductionYear: string
}
