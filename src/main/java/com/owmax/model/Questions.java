package com.owmax.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Questions entity. @author MyEclipse Persistence Tools
 */

public class Questions implements java.io.Serializable {

	// Fields

	private Short id;
	private String title;
	private Short type;
	private Short maxSelection;
	private Set jumps = new HashSet(0);
	private Set blankses = new HashSet(0);
	private Set selectionses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Questions() {
	}

	/** minimal constructor */
	public Questions(String title, Short type) {
		this.title = title;
		this.type = type;
	}

	/** full constructor */
	public Questions(String title, Short type, Short maxSelection, Set jumps,
			Set blankses, Set selectionses) {
		this.title = title;
		this.type = type;
		this.maxSelection = maxSelection;
		this.jumps = jumps;
		this.blankses = blankses;
		this.selectionses = selectionses;
	}

	// Property accessors

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public Short getMaxSelection() {
		return this.maxSelection;
	}

	public void setMaxSelection(Short maxSelection) {
		this.maxSelection = maxSelection;
	}

	public Set getJumps() {
		return this.jumps;
	}

	public void setJumps(Set jumps) {
		this.jumps = jumps;
	}

	public Set getBlankses() {
		return this.blankses;
	}

	public void setBlankses(Set blankses) {
		this.blankses = blankses;
	}

	public Set getSelectionses() {
		return this.selectionses;
	}

	public void setSelectionses(Set selectionses) {
		this.selectionses = selectionses;
	}

}