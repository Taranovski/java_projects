/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gem;

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.09 at 11:34:58 PM EET 
//
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="gem">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="origin">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;pattern value="[A-Z]([a-z])+"/>
 *                         &lt;maxLength value="20"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="value">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *                         &lt;minInclusive value="0"/>
 *                         &lt;maxInclusive value="1000000"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="visual_parameters">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="color">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="white"/>
 *                                   &lt;enumeration value="blue"/>
 *                                   &lt;enumeration value="red"/>
 *                                   &lt;enumeration value="orange"/>
 *                                   &lt;enumeration value="yellow"/>
 *                                   &lt;enumeration value="green"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="transparency">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *                                   &lt;minInclusive value="0"/>
 *                                   &lt;maxInclusive value="100"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="sides">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                                   &lt;minInclusive value="4"/>
 *                                   &lt;maxInclusive value="1000"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="preciousness" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="name">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;pattern value="[A-Z]([a-z])+"/>
 *                       &lt;maxLength value="20"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "gem"
})
@XmlRootElement(name = "gems")
public class Gems {

    protected List<Gems.Gem> gem;

    /**
     * Gets the value of the gem property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the gem property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGem().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Gems.Gem }
     *
     *
     * @return 
     */
    public List<Gems.Gem> getGem() {
        if (gem == null) {
            gem = new ArrayList();
        }
        return this.gem;
    }

    @Override
    public String toString() {
        return gem.toString();
    }

    /**
     * <p>
     * Java class for anonymous complex type.
     *
     * <p>
     * The following schema fragment specifies the expected content contained
     * within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="origin">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;pattern value="[A-Z]([a-z])+"/>
     *               &lt;maxLength value="20"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="value">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
     *               &lt;minInclusive value="0"/>
     *               &lt;maxInclusive value="1000000"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="visual_parameters">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="color">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="white"/>
     *                         &lt;enumeration value="blue"/>
     *                         &lt;enumeration value="red"/>
     *                         &lt;enumeration value="orange"/>
     *                         &lt;enumeration value="yellow"/>
     *                         &lt;enumeration value="green"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="transparency">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
     *                         &lt;minInclusive value="0"/>
     *                         &lt;maxInclusive value="100"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="sides">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
     *                         &lt;minInclusive value="4"/>
     *                         &lt;maxInclusive value="1000"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="preciousness" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="name">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;pattern value="[A-Z]([a-z])+"/>
     *             &lt;maxLength value="20"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "origin",
        "value",
        "visualParameters"
    })
    public static class Gem {

        @XmlElement(required = true)
        protected String origin;
        protected double value;
        @XmlElement(name = "visual_parameters", required = true)
        protected Gems.Gem.VisualParameters visualParameters;
        @XmlAttribute(name = "preciousness")
        protected Boolean preciousness;
        @XmlAttribute(name = "name")
        protected String name;

        @Override
        public String toString() {
            return name + ": {origin: " + origin + "; "
                    + (preciousness ? "precious" : "half-precious") + "; "
                    + visualParameters.toString() + " value: " + value + "}";
        }

        /**
         * Gets the value of the origin property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getOrigin() {
            return origin;
        }

        /**
         * Sets the value of the origin property.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setOrigin(String value) {
            this.origin = value;
        }

        /**
         * Gets the value of the value property.
         *
         * @return 
         */
        public double getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value
         */
        public void setValue(double value) {
            this.value = value;
        }

        /**
         * Gets the value of the visualParameters property.
         *
         * @return possible object is {@link Gems.Gem.VisualParameters }
         *
         */
        public Gems.Gem.VisualParameters getVisualParameters() {
            return visualParameters;
        }

        /**
         * Sets the value of the visualParameters property.
         *
         * @param value allowed object is {@link Gems.Gem.VisualParameters }
         *
         */
        public void setVisualParameters(Gems.Gem.VisualParameters value) {
            this.visualParameters = value;
        }

        /**
         * Gets the value of the preciousness property.
         *
         * @return possible object is {@link Boolean }
         *
         */
        public Boolean isPrecisuoness() {
            return preciousness;
        }

        /**
         * Sets the value of the preciousness property.
         *
         * @param value allowed object is {@link Boolean }
         *
         */
        public void setPreciousness(Boolean value) {
            this.preciousness = value;
        }

        /**
         * Gets the value of the name property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * <p>
         * Java class for anonymous complex type.
         *
         * <p>
         * The following schema fragment specifies the expected content
         * contained within this class.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="color">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="white"/>
         *               &lt;enumeration value="blue"/>
         *               &lt;enumeration value="red"/>
         *               &lt;enumeration value="orange"/>
         *               &lt;enumeration value="yellow"/>
         *               &lt;enumeration value="green"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="transparency">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
         *               &lt;minInclusive value="0"/>
         *               &lt;maxInclusive value="100"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="sides">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
         *               &lt;minInclusive value="4"/>
         *               &lt;maxInclusive value="1000"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "color",
            "transparency",
            "sides"
        })
        public static class VisualParameters {

            @XmlElement(required = true)
            protected String color;
            protected double transparency;
            protected int sides;

            @Override
            public String toString() {
                return color + ", transp. " + transparency + ", " + sides + " sides";
            }

            /**
             * Gets the value of the color property.
             *
             * @return possible object is {@link String }
             *
             */
            public String getColor() {
                return color;
            }

            /**
             * Sets the value of the color property.
             *
             * @param value allowed object is {@link String }
             *
             */
            public void setColor(String value) {
                this.color = value;
            }

            /**
             * Gets the value of the transparency property.
             *
             * @return 
             */
            public double getTransparency() {
                return transparency;
            }

            /**
             * Sets the value of the transparency property.
             *
             * @param value
             */
            public void setTransparency(double value) {
                this.transparency = value;
            }

            /**
             * Gets the value of the sides property.
             *
             * @return 
             */
            public int getSides() {
                return sides;
            }

            /**
             * Sets the value of the sides property.
             *
             * @param value
             */
            public void setSides(int value) {
                this.sides = value;
            }
        }
    }
}