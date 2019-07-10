import {ADD, REMOVE, TYPE_WIDGET_DRAG, UPDATE} from './Consts'

export const addWidget = (widget) => {
    return {
        type: ADD,
        widget: widget
    }
}
export const widgetStartDrag = (id) => {
    console.log("widgetStartDrag: ", id);
    return {
        type: TYPE_WIDGET_DRAG,
        id: id
    }
}
export const removeWidget = (id) => {
    console.log("removeWidget: ", id);
    return {
        type: REMOVE,
        id: id
}
}
export const updateWidget = (widget) => {
    console.log("updateWIdget: ", widget);
    return {
        type: UPDATE,
        widget: widget
    }
}