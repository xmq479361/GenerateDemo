import React, {Component} from 'react'
import "../../assets/preview_styles.css";
import {connectWithWrapper, wrapperWithOperate} from "./BasePreviewWidget";

class _PreviewWidget extends Component {

    renderWidget = () => {
        let {
            name = 'Unknown',
            focusId = '为udubgtu',
            id = "UnknownId",
            type = "Unknowntype",
        } = this.props;
        return (
            <div>{type}, id: {id}</div>
        )
    }

    render() {
        let {
            name = 'Unknown',
            id = "UnknownId",
            clickToUpdate,
            clickToRemove,
            clickToDrag,
            clickToCopy
        } = this.props;
        return wrapperWithOperate(name, id, this.renderWidget(),
            clickToUpdate,
            clickToRemove,
            clickToDrag,
            clickToCopy
        )
    }
}

const PreviewWidget = connectWithWrapper(_PreviewWidget)

class _PreviewContainer extends Component {
    render() {
        let {
            name = 'Unknown',
            id = "UnknownId",
            clickToUpdate,
            clickToRemove,
            clickToDrag,
            clickToCopy
        } = this.props;
        return wrapperWithOperate(name, id, this.renderWidget(),
            clickToUpdate,
            clickToRemove,
            clickToDrag,
            clickToCopy
        )

    }

    renderWidget = () => {
        let {
            flex_direction = 'column',
            justify_content = 'start',
            align_items = 'start',
            name = 'Unknown',
            focusId = '为udubgtu',
            id = "UnknownId",
        } = this.props;
        // console.log(`PreviewContainer renderWidget(${id}):`, name, children);
        // onDragEnter={()=>{console.log(`onDragEnter: ${id}`)}}
        return (
            <div className="drag-widget-view"
                 onMouseEnter={()=>{console.log(`onMouseEnter: ${id}`)}}
                 onDragStart={()=>{console.log(`onDragStart: ${id}`)}}
                 onDragEnter={() => this.onDragEnter(id)}>
                {this.renderChildren()}
            </div>
        )
    }
    renderChildren = () => {
        let {
            children = [],
            id
        } = this.props;
        let parentId = id;
        return children.map(child => {
            let {type, id, name} = child;
            console.log(`renderChildren(${parentId}):`, id, name, type);
            switch (type) {
                case 'container':
                    return (<PreviewContainer {...child}/>)
                default:
                    return (<PreviewWidget {...child}/>)
            }
        });
    }
}


const mapStateToProps = (state) => {
}
const mapDispatchToProps = (dispatch) => {
    return {
        onDragEnter: (id) => {
            console.log("onDragEnter", id,)
        }
    }
}
const PreviewContainer = connectWithWrapper(_PreviewContainer,
    mapStateToProps, mapDispatchToProps
)
export default PreviewContainer