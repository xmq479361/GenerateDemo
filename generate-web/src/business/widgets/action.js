import {ADD, REMOVE, UPDATE} from './Consts'

export const addWidget = (widget) => {
    return {
        type: ADD,
        widget: widget
    }
}
export const removeWidget = (widget) => {
    return {
        type: REMOVE,
        widget: widget
    }
}
export const updateWidget = (widget) => {
    console.log("updateWIdget: ", widget);
    return {
        type: UPDATE,
        widget: widget
    }
}