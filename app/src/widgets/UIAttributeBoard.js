import React, {Component} from 'react'
import {connect} from 'react-redux'
import {Attribute} from '../config/UIConfigConsts'
import '../assets/app.css'
import {ControlLabel, FormControl, FormGroup, HelpBlock, Col} from "react-bootstrap";
import {Size} from "react-bootstrap/es/utils/StyleConfig";

// import Dropdown from 'react-bootstrap/lib/Dropdown'
function FieldGroup({id, label, help, ...props}) {
    return (
        <FormGroup controlId={id}>
            <ControlLabel>{label}</ControlLabel>
            <FormControl {...props} />
            {help && <HelpBlock>{help}</HelpBlock>}
        </FormGroup>
    );
}

class AttributeItem extends Component {
    render() {
        let {key, type, def, value, name, unit} = this.props;
        if (value == undefined) {
            value = def;
        }
        // let {title} = value || def
        console.log(key, value, def, type, Attribute.propTypes[type])

        function renderByType(type) {
            switch (type) {
                case 'gravity':
                    return (
                        <FormGroup controlId="formControlsSelect">
                            <ControlLabel>{name}</ControlLabel>
                            <FormControl componentClass="select" placeholder="select">
                                <option value="left">left</option>
                                <option value="center">center</option>
                                <option value="right">right</option>
                            </FormControl>
                        </FormGroup>
                    )
                default:
                    // return (<input key={key} type="text"
                    //                autoComplete="off" className="el-input__inner"
                    //                value={def}/>
                    return (
                        <FormGroup controlId="formHorizontal">
                            <Col componentClass={ControlLabel} sm={3}>
                                {name}
                            </Col>
                            <Col sm={3}>
                                <FormControl type="text" placeholder="Enter text" value={def}/>
                            </Col>
                        </FormGroup>
                    )
                    // return (<FieldGroup
                    //         id="formControlsText"
                    //         type="text"
                    //         label={name}
                    //         placeholder="Enter text"
                    //         value={def}
                    //     />
                    // )
            }
        }

        return (
            <div className="el-form-item el-form-item--small">
                {renderByType(type)}
            </div>
        );
    }
}

class UIAttributeBoard extends Component {
    render() {
        console.log("UIAttributeBoard: ")
        console.log(this.props.attrs)
        let {attrs} = this.props || [];
        return (
            <aside >
                <fieldset>
                    <form
                        bsSize="small">
                        {attrs.map(attr => {
                            let {key} = attr;
                            return (<AttributeItem key={key} {...attr}/>)
                        })}
                    </form>
                </fieldset>
            </aside>
        )
    }
}

const mapStateToProps = (state) => {
    console.log('mapStateToProps', state)
    return {
        attrs: state.focusWidget.attrs
    }
}
const mapDispatchToProps = (dispatch) => {
    return {}
}
export default connect(mapStateToProps, mapDispatchToProps)
(UIAttributeBoard);