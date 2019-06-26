import React, {Component} from 'react'
import {connect} from 'react-redux'
import '../assets/app.css'
import {Col, Grid, Row} from "react-bootstrap";

function sliceArr(array, size) {
    let result = [];
    for (let x = 0; x < Math.ceil(array.length / size); x++) {
        let start = x * size;
        let end = start + size;
        result.push(array.slice(start, end));
    }
    return result;
}

class UIElementBoard extends Component {
    render() {
        return (
            <aside>
                <fieldset>
                    {this.renderElements()}
                </fieldset>
            </aside>
        )
    }

    renderRowElements = (rowEles) => {
        return (
            <Row className="show-grid">
                {rowEles.map(ele => {
                    let {name, type} = ele
                    return (
                        <Col xs={1} md={1}>
                            <code>{name}</code>
                        </Col>
                    )
                })}
            </Row>
        )
    }

    renderElements() {
        console.log("UIElementBoard: ")
        console.log(this.props.uiElements)
        let {uiElements} = this.props || [];
        let date = [];
        let rowIndex = 0;
        for (let i = 0; i < uiElements.length; i++) {
            if (i % 3 == 0) {
                rowIndex++;
            }
        }
        const ROW_ITEM_MAX = 3;
        let rowEles = sliceArr(uiElements, ROW_ITEM_MAX) || [];
        return (
            <Grid>
                {rowEles.map(rowEles => this.renderRowElements(rowEles))}
            </Grid>
        )
    }
}

const mapStateToProps = (state) => {
    return {
        uiElements: state.uiElements
    }
}
const mapDispatchToProps = (dispatch) => {
    return {}
}
export default connect(
    mapStateToProps,
    mapDispatchToProps
)(
    UIElementBoard
);