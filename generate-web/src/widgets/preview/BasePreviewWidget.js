import React, {Component} from 'react'
import {removeWidget, updateWidget, widgetStartDrag} from "../../business/widgets/action";
import {connect} from "react-redux";
class BaseWidget extends Component{
    clickToUpdate =()=>{}
    clickToDrag =()=>{}
    clickToRemove =()=>{}
    clickToCopy =()=>{}
    onDragStart =(id)=>{
        console.log(`onDragStart: ${id}`)
    }
    onDragEnter =(id)=>{
        console.log(`onDragEnter: ${id}`)
    }
    onMouseEnter =(id)=>{
        console.log(`onMouseEnter: ${id}`)
    }
}
export default BaseWidget;
const baseMapStateToProps = (state) => {
    let {
        focusWidget
    } = state
    let {
        id
    } = focusWidget
    return {
        focusId: id
    }
}
const baseMapDispatchToProps = (dispatch) => {
    return {
        clickToUpdate: (widget) => {
            dispatch(updateWidget(widget))
        },
        clickToDrag: (widget) => {
            dispatch(widgetStartDrag(widget))
        },
        clickToRemove: (id) => {
            dispatch(removeWidget(id))
        },
        clickToCopy: (widget) => {
            dispatch(updateWidget(widget))
        },
    }
}

export function connectWithWrapper(WrappedComponent, mapStateToProps={}, mapDispatchToProps={}) {
    return connect(
        Object.assign(baseMapStateToProps, mapStateToProps),
        Object.assign(baseMapDispatchToProps, mapDispatchToProps),
    )(WrappedComponent)
}

export function wrapperWithOperate(name, id, children, onFocuseOn = () => {
}, onRemove=()=>{}, onDragStart=()=>{}, onCopy=()=>{}) {
    return (<div className="drag-widget-view-root"
                 onClick={() => onFocuseOn(id)}>
        <div className="drag-widget-view-content">
            <div className="drag-widget-view-action" style={{}}>
                <label style={{width: "100px"}}>{name}</label>
                <i className="action-remove" onClick={() => {console.log("onClickRemove",onRemove);onRemove(id)}}>Remove</i>
                {/*<i className="action-copy" onClick={() => onCopy(id)}>Copy</i>*/}
                <i className="action-drag" onClick={() => onDragStart(id)}>Drag</i>
            </div>

            <span style={{alignSelf: "stretch", minHeight: '100px', backgroundColor: "#ffc"}}>
                {children}
                </span>
        </div>
    </div>)
}

// class BasePreviewWidget extends Component {
//     wrapperWithOperate = (name, id, children) => {
//         return (<div className="drag-widget-view-root" onClick={() => this.clickToUpdate(id)}>
//             <div className="drag-widget-view-content">
//                 <div className="drag-widget-view-action" style={{}}>
//                     <label style={{width: "100px"}}>{name}</label>
//                     <i className="action-remove">Remove</i>
//                     <i className="action-copy">Copy</i>
//                     <i className="action-drag">Drag</i>
//                 </div>
//
//                 <span style={{alignSelf: "stretch", minHeight: '100px', backgroundColor: "#ffc"}}>
//                     {children}
//                     </span>
//             </div>
//         </div>)
//     }
//
//     render() {
//         let {
//             name = 'Unknown',
//             focusId = '为udubgtu',
//             id = "UnknownId",
//         } = this.props;
//         // {this.props.children.map(child=> <div>{child}</div>)}
//         // var childs = React.Children.toArray(this.props.children);
//         console.log("Preview render", name, 'focusId:', focusId, id, this.props);
//         return this.wrapperWithOperate(name, id,
//             this.renderWidget()
//         )
//     }
//
//     renderWidget() {
//     }
// }
// const BasePreviewWidget = {
//     mapStateToProps,
//     mapDispatchToProps,
//
// }
// // export default {
// //     mapStateToProps,
// //     mapDispatchToProps,
// //     wrapperWithOperate,
// //
// // }
// export default BasePreviewWidget
// export function wrapperWithOperate;