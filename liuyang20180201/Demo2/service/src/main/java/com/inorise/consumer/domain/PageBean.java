package com.inorise.consumer.domain;

public class PageBean {
    private Integer page=1;
    private Integer rows=10;
    private Long  filmId;
    private String description;
    private String releaseYear;
    private Short length;
    private String ids;
    private Long  filmIdRep;

    public Long getFilmIdRep() {
		return filmIdRep;
	}

	public void setFilmIdRep(Long filmIdRep) {
		this.filmIdRep = filmIdRep;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    public PageBean() {
    }

    public PageBean(Integer page, Integer rows, Long filmId, String description, String releaseYear, Short length) {
        this.page = page;
        this.rows = rows;
        this.filmId = filmId;
        this.description = description;
        this.releaseYear = releaseYear;
        this.length = length;
    }
}
