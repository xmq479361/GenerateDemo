import PropTypes from 'prop-types';
export const Left= "left";
export const Right= "right";
export const Center= "center";
export class Attribute {
}
export class Gravity {

}
Attribute.propTypes = {
    gravity: PropTypes.oneOf([Left, Right, Center]),
    dimension: PropTypes.number,
    reference: PropTypes.string,
    visible: PropTypes.bool
}
